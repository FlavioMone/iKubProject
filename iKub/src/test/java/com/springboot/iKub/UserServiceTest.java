package com.springboot.iKub;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.iKub.Entity.Role;
import com.springboot.iKub.Entity.User;
import com.springboot.iKub.repository.UserRepository;

@RunWith(SpringRunner.class)
class UserServiceTest {

    private UserRepository userRepository;

	@Test
	void test() {
		//fail("Not yet implemented");
	}

	@Test
	void testFindByEmail() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = new User();
        user.setFirstName("Flavio");
        user.setLastName("Mone");
        user.setEmail("flavio@test.com");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        this.userRepository.save(user);
        
        assertTrue(userRepository.findByEmail("flavio@test.com") != null);
	}
	
	@Test
	void testSave() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = new User();
        user.setFirstName("Flavio");
        user.setLastName("Mone");
        user.setEmail("flavio@test.com");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        
        assertTrue(userRepository.save(user).getFirstName() == "Flavio");
	}
	
	@Test
	void testLoadByUsername() {
		//same as findByEmail
	}
	
	
	@Before
	public void setup() {
		User user = new User();
		user.setEmail("flavio@test.com");
		Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
	}
	
	@Test
	void testGetLoggedUserEmail() {
		
	}
	
}
