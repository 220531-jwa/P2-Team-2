package com.sclass.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.Suite;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sclass.repositories.PartDAO;

@Suite
@ExtendWith(MockitoExtension.class)
class PartServiceTests {

	@InjectMocks
	static PartService partService;

	@Mock
	static PartDAO partDaoMock;

	@BeforeAll
	static void setUpBeforeClass() {
		partService = new PartService(partDaoMock);
	}

	@AfterAll
	static void tearDownAfterClass() {
	}

}
