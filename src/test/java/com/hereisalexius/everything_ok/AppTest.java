package com.hereisalexius.everything_ok;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void whenSample1() {
		
		assertTrue(true);
	}

	public void whenSample2() {
		assertTrue(true);
	}

	public void whenSample3() {
		assertTrue(true);
	}

	public void whenSample4() {
		assertTrue(true);
	}
}
