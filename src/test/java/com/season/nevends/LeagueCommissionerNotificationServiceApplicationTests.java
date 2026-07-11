/*
package com.season.nevends;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LeagueCommissionerNotificationServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void applicationClassHasSpringBootApplicationAnnotation() {
		SpringBootApplication annotation = LeagueCommissionerNotificationServiceApplication.class
				.getAnnotation(SpringBootApplication.class);

		assertNotNull(annotation);
	}

	@Test
	void applicationMainMethodExistsAndIsStatic() throws NoSuchMethodException {
		Method mainMethod = LeagueCommissionerNotificationServiceApplication.class
				.getMethod("main", String[].class);

		assertTrue(java.lang.reflect.Modifier.isStatic(mainMethod.getModifiers()));
		assertTrue(java.lang.reflect.Modifier.isPublic(mainMethod.getModifiers()));
	}

}
*/