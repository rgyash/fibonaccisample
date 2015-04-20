package com.emc.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.emc.example.exception.FibonacciServiceException;
import com.emc.example.service.FibonacciService;

public class FibonacciServiceTest {

	private static FibonacciService fibonacciService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fibonacciService = new FibonacciService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSeries0() {
		try {
			assertTrue("[]".equals(fibonacciService.findSeriesofFibonacciNums(0)));
		} catch (FibonacciServiceException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSeries1() {
		try {
			assertTrue("[0]".equals(fibonacciService.findSeriesofFibonacciNums(1).toString()));
		} catch (FibonacciServiceException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSeries2() {
		try {
			assertTrue("[0,1]".equals(fibonacciService.findSeriesofFibonacciNums(2).toString()));
		} catch (FibonacciServiceException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSeriesNegative() {
		try {
			fibonacciService.findSeriesofFibonacciNums(-2);
		} catch (FibonacciServiceException e) {
			assertTrue("The series of Fibonacci can not be negative".equalsIgnoreCase(e.getMessage()));
		}
	}
}
