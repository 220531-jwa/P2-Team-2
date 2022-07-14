package com.sclass.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.Suite;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sclass.models.Build;
import com.sclass.models.Part;
import com.sclass.models.Part.manufacturer;
import com.sclass.models.Part.partType;
import com.sclass.repositories.BuildDAO;
import com.sclass.repositories.PartDAO;

@Suite
@ExtendWith(MockitoExtension.class)
public class BuildServiceTests {

	@InjectMocks
	BuildService buildService;

	@Mock
	BuildDAO buildDaoMock;
	
	@Mock
	PartDAO partDaoMock;
	
	static List<Part> parts;
	
	@BeforeEach
	public void setupEach() {
		buildService = new BuildService(buildDaoMock, partDaoMock);
		parts = new ArrayList<>();
	}

	@Test
	public void createAValidBuild() {		
		parts.add(new Part(1, "Generic Mobo", partType.MOBO, 25, 100.00, manufacturer.AMD, 4));
		parts.add(new Part(2, "Generic CPU", partType.CPU, 75, 250.00, manufacturer.AMD, 0));
		parts.add(new Part(3, "Generic RAM", partType.RAM, 50, 100.00, null, 2));
		parts.add(new Part(4, "Generic Storage", partType.STORAGE, 25, 100.00, null, 0));
		parts.add(new Part(5, "Generic Power Supply", partType.PSU, 500, 100.00, null, 0));
		parts.add(new Part(6, "Generic Case", partType.CASE, 0, 100.00, null, 0));
		
		Build newBuild = new Build(1, 1, "My Build", 1, 2, 3, 4, 5, 6, false);
		
		when(partDaoMock.getPartsInBuild(anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(parts);
		
		when(buildDaoMock.createBuild(anyInt(), anyString(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt(),
				anyInt(), anyBoolean())).thenReturn(newBuild);
		
		try {
			assertEquals(newBuild, buildService.createBuild(1, "My Build", 1, 2, 3, 4, 5, 6, false));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createBuildWithIncompatibleCPUShouldThrowException() {
		parts.add(new Part(1, "Generic Mobo", partType.MOBO, 25, 100.00, manufacturer.AMD, 4));
		parts.add(new Part(9, "Generic CPU", partType.CPU, 75, 250.00, manufacturer.INTEL, 0));
		parts.add(new Part(3, "Generic RAM", partType.RAM, 50, 100.00, null, 2));
		parts.add(new Part(4, "Generic Storage", partType.STORAGE, 25, 100.00, null, 0));
		parts.add(new Part(5, "Generic Power Supply", partType.PSU, 500, 100.00, null, 0));
		parts.add(new Part(6, "Generic Case", partType.CASE, 0, 100.00, null, 0));
		
		when(partDaoMock.getPartsInBuild(anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(parts);
		
		Exception thrown = assertThrows(Exception.class, () -> { buildService.createBuild(1, "My Build", 1, 9, 3, 
				4, 5, 6, false); });
		
		assertEquals("Can't create build: CPU isn't compatible with selected motherboard.", thrown.getMessage());
	}

	@Test
	public void createBuildWithMoreRAMThanSlotsAvailableShouldThrowException() {
		parts.add(new Part(2, "Generic Mobo", partType.MOBO, 25, 100.00, manufacturer.AMD, 2));
		parts.add(new Part(9, "Generic CPU", partType.CPU, 75, 250.00, manufacturer.AMD, 0));
		parts.add(new Part(3, "Generic RAM", partType.RAM, 50, 100.00, null, 2));
		parts.add(new Part(4, "Generic Storage", partType.STORAGE, 25, 100.00, null, 0));
		parts.add(new Part(5, "Generic Power Supply", partType.PSU, 500, 100.00, null, 0));
		parts.add(new Part(6, "Generic Case", partType.CASE, 0, 100.00, null, 0));
		
		when(partDaoMock.getPartsInBuild(anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(parts);
		
		Exception thrown = assertThrows(Exception.class, () -> { buildService.createBuild(1, "My Build", 2, 9, 3, 
				4, 5, 6, true); });
		
		assertEquals("Can't create build: Motherboard doesn't have enough RAM slots.", thrown.getMessage());
	}
	
	@Test
	public void createBuildWithInsufficientWattageShouldThrowException() {
		parts.add(new Part(1, "Generic Mobo", partType.MOBO, 25, 100.00, manufacturer.INTEL, 4));
		parts.add(new Part(9, "Generic CPU", partType.CPU, 75, 250.00, manufacturer.INTEL, 0));
		parts.add(new Part(3, "Generic RAM", partType.RAM, 50, 100.00, null, 2));
		parts.add(new Part(4, "Generic Storage", partType.STORAGE, 25, 100.00, null, 0));
		parts.add(new Part(12, "Generic Power Supply", partType.PSU, 150, 100.00, null, 0));
		parts.add(new Part(6, "Generic Case", partType.CASE, 0, 100.00, null, 0));
		
		when(partDaoMock.getPartsInBuild(anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(parts);
		
		Exception thrown = assertThrows(Exception.class, () -> { buildService.createBuild(1, "My Build", 1, 9, 3, 
				4, 12, 6, false); });
		
		assertEquals("Can't create build: PSU doesn't supply enough wattage to power the current build.", thrown.getMessage());
	}

	@Test
	public void getBuildUsingValidId() {
		Build mockBuild = new Build(1, 1, "My Build", 1, 2, 3, 4, 5, 6, false);

		when(buildDaoMock.getBuildById(anyInt())).thenReturn(mockBuild);

		try {
			assertEquals(mockBuild, buildService.getBuildById(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getBuildWithInvalidIdShouldThrowException() {
		int invalidBuildId = -1;

		Exception thrown = assertThrows(Exception.class, () -> {
			buildService.getBuildById(invalidBuildId);
		});

		assertEquals("Build with id " + invalidBuildId + " doesn't exist.", thrown.getMessage());
	}

	@Test
	public void getAllBuildsForUser() {
		List<Build> builds = new ArrayList<>();
		builds.add(new Build(1, 1, "My Build", 1, 2, 3, 4, 5, 6, false));
		builds.add(new Build(2, 1, "My Second Build", 7, 8, 9, 10, 11, 12, true));

		when(buildDaoMock.getAllBuildsForUser(anyInt())).thenReturn(builds);

		assertEquals(builds, buildService.getAllBuildsForUser(1));
	}
}
