package com.sclass.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


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
import com.sclass.services.PartService;

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
	public void GetPartWithValidId() {
		Part part = new Part(1, "4-Slot AMD Motherboard", partType.MOBO, 25, 100.00, manufacturer.AMD, 4);

		when(partDaoMock.getPartById(anyInt())).thenReturn(part);

		try {
			assertEquals(part, partService.getPartById(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void GetPartWithInvalidIdShouldThrowException() {
		int invalidPartId = -1;
		Exception thrown = assertThrows(Exception.class, () -> {
			partService.getPartById(invalidPartId);
		});

		assertEquals("Part with ID: " + invalidPartId + " doesn't exist.", thrown.getMessage());

	}

	@Test
	public void testGetPartsByType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllParts() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllPartsWithParams() {
		fail("Not yet implemented");
	}

}
