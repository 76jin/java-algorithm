package com.main.recursive;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class TowerOfHannoiTest {
	
	private TowerOfHannoi hannoi;
	
	@Before
	public void setup() {
		hannoi = new TowerOfHannoi();
	}

	@Test
	public void test() {
//		assertThat(hannoi.printHannoi(1), is(1));
	}

}
