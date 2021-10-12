package com.simplilearn.webapp.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitStandardMethodTest {
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("--- Before all ---");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("--- After all ---");
	}

	@BeforeEach
	void setUp() {
		System.out.println("-- Before each test !--");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("-- After each test !--");
	}
	
	@Test
	void testOne() {
		System.out.println("-- Test one is completed ! --");
	}
	
	@Test
	void testTwo() {
		System.out.println("-- Test two is completed ! --");
	}
	
	@Test
	void testThree() {
		System.out.println("-- Test three is completed ! --");
	}
}
