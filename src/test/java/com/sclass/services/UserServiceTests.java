package com.sclass.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sclass.models.User;
import com.sclass.repositories.UserDAO;
import com.sclass.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

	@InjectMocks
	UserService userService;

	@Mock
	UserDAO userDaoMock;

	@BeforeEach
	public void setupEach() {
		userService = new UserService(userDaoMock);
	}

	@Test
	public void loginWithValidInput() {

		User mockUser = new User(1, "username", "pass");

		when(userDaoMock.getUserByUsername(anyString())).thenReturn(mockUser);

		User loggedInUser = userService.login("username", "pass");

		assertEquals(mockUser, loggedInUser);
	}

	@Test
	public void loginWithInvalidUsernameShouldReturnNull() {

		when(userDaoMock.getUserByUsername(anyString())).thenReturn(null);

		User loggedInUser = userService.login("username", "pa$$word");

		assertEquals(null, loggedInUser);
	}

	@Test
	public void loginWithValidUsernameInvalidShouldReturnNull() {

		User mockUser = new User(1, "username", "pass");

		when(userDaoMock.getUserByUsername(anyString())).thenReturn(mockUser);

		User loggedInUser = userService.login("username", "pa$$word");

		assertEquals(null, loggedInUser);
	}

	@Test
	public void createUserAccountwithValidInput() {
		User mockUser = new User(1, "username", "pass");

		when(userDaoMock.getUserByUsername(anyString())).thenReturn(null);

		when(userDaoMock.createUserAccount(anyString(), anyString())).thenReturn(mockUser);

		User createdUser = userService.createUserAccount("username", "pass");

		assertEquals(mockUser, createdUser);
	}

	@Test
	public void createUserAccountwithDuplicateUsernameShouldThrowException() {
		User uAttempt = new User(1, "someUsername", "pass");
		
		when(userDaoMock.getUserByUsername(anyString())).thenReturn(uAttempt);
		
		Exception thrown = assertThrows(Exception.class, () -> { userService.createAccount("someUsername", "pass"); });
		
		assertEquals("Account with username " + uAttempt.getUsername() + " already exists.", thrown.getMessage());
	}

}
