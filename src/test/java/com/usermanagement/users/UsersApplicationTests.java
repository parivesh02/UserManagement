package com.usermanagement.users;
import static org.assertj.core.api.Assertions.assertThat;

import com.usermanagement.users.entity.User;
import com.usermanagement.users.repository.UserRepository;
import com.usermanagement.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UsersApplicationTests {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserService userService;

	@DisplayName("JUnit test for saveLicense method")
	@Test
	public void test_saveUser(){
		User user = new User(1L,"license","this is license","license-00");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userService.saveUser(user));
	}

	@DisplayName("JUnit test for deleteLicenseById method")
	@Test
	public void testDeleteUser() {
		long userId=1;
		userService.deleteUserById(userId);
		verify(userRepository,times(1)).deleteById(userId);
	}

	@DisplayName("JUnit test for findUserById method")
	@Test
	public void testFindUser() {
		long userId=1;
		userService.findUserById(userId);
		verify(userRepository,times(1)).findByUserId(userId);
	}

	@DisplayName("JUnit test for findUserById method")
	@Test
	public void testUpdateUser() {
		long userId=1;
		User user = new User(1L,"license","this is license","license-00");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userService.saveUser(user));
	}
}
