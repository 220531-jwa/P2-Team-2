package com.sclass.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
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

import com.sclass.models.Part;
import com.sclass.models.Part.manufacturer;
import com.sclass.models.Part.partType;
import com.sclass.repositories.PartDAO;

@Suite
@ExtendWith(MockitoExtension.class)
class PartServiceTests {

	@InjectMocks
	PartService partService;

	@Mock
	PartDAO partDaoMock;

	@BeforeEach
	public void setUpBeforeClass() {
		partService = new PartService(partDaoMock);
	}

	@Test
	void GetPartWithIdValid() {
		Part part = new Part(1, "4-Slot AMD Motherboard", partType.MOBO, 25, 200.00, manufacturer.AMD, 4);

		when(partDaoMock.getPartById(anyInt())).thenReturn(part);

		try {
			assertEquals(part, partService.getPartById(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void GetPartWithInvalidIdShouldThrowException() {
		int invalidPartId = -1;
		Exception thrown = assertThrows(Exception.class, () -> {
			partService.getPartById(invalidPartId);
		});

		assertEquals("Part with ID: " + invalidPartId + " doesn't exist.", thrown.getMessage());

	}

	@Test
	void GetPartsByTypeValid() {
		List<Part> mockParts = new ArrayList<>();
		mockParts.add(new Part(1, "4-Slot AMD Motherboard", partType.MOBO, 25, 200.00, manufacturer.AMD, 4));
		mockParts.add(new Part(2, "Generic SSD", partType.STORAGE, 25, 100.00, null, 0));
		mockParts.add(new Part(3, "Generic RAM", partType.RAM, 25, 100.00, null, 2));
		mockParts.add(new Part(4, "4-Slot Intel Motherboard", partType.MOBO, 25, 200.00, manufacturer.INTEL, 4));

		when(partDaoMock.getPartsByType(any(Part.partType.class))).thenReturn(mockParts);

		List<Part> parts = new ArrayList<>();
		try {
			parts = partService.getPartsByType(partType.MOBO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(parts, mockParts);

	}

//	@Test
//	void testGetPartsByTypeInvalid() {
//
//	}

	@Test
	void GetAllPartsValid() {
		List<Part> mockParts = new ArrayList<>();
		mockParts.add(new Part(1, "4-Slot AMD Motherboard", partType.MOBO, 25, 200.00, manufacturer.AMD, 4));
		mockParts.add(new Part(2, "Generic SSD", partType.STORAGE, 25, 100.00, null, 0));
		mockParts.add(new Part(3, "Generic RAM", partType.RAM, 25, 100.00, null, 2));
		mockParts.add(new Part(4, "4-Slot Intel Motherboard", partType.MOBO, 25, 200.00, manufacturer.INTEL, 4));

		when(partDaoMock.getAllParts()).thenReturn(mockParts);

		List<Part> parts = new ArrayList<>();
		try {
			parts = partService.getAllParts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(parts, mockParts);

	}

	@Test
	void testGetAllPartsInvalid() {
		Exception thrown = assertThrows(Exception.class, () -> {
			partService.getAllParts();
		});

		assertEquals("We are plum out of parts. Check back later!", thrown.getMessage());
	}

	@Test
	void GetAllPartsWithParamsValid() {
		List<Part> mockParts = new ArrayList<>();
		mockParts.add(new Part(1, "4-Slot AMD Motherboard", partType.MOBO, 25, 200.00, manufacturer.AMD, 4));
		mockParts.add(new Part(2, "Generic SSD", partType.STORAGE, 25, 100.00, null, 0));
		mockParts.add(new Part(3, "Generic RAM", partType.RAM, 25, 100.00, null, 2));
		mockParts.add(new Part(4, "4-Slot Intel Motherboard", partType.MOBO, 25, 200.00, manufacturer.INTEL, 4));

		when(partDaoMock.getAllPartsWithParams(anyDouble(), anyDouble())).thenReturn(mockParts);

		List<Part> parts = new ArrayList<>();
		try {
			parts = partService.getAllPartsWithParams(150, 250);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(parts, mockParts);

	}

	@Test
	void testGetAllPartsWithParamsInvalid() {
		double priceFloor = 1000.00;
		double priceCeiling = 2000.00;
		Exception thrown = assertThrows(Exception.class, () -> {
			partService.getAllPartsWithParams(priceFloor, priceCeiling);
		});

		assertEquals("No parts available between: $" + priceFloor + " and $" + priceCeiling, thrown.getMessage());
	}

}
