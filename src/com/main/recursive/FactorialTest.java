package com.main.recursive;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class FactorialTest {
	
	private Factorial fact;
	
	@Before
	public void setUp() {
		fact = new Factorial();
	}

	@Test
	public void Factorialtest() {
		assertThat(fact.factorial(1), is(1));
		assertThat(fact.factorial(2), is(2));
		assertThat(fact.factorial(3), is(6));
		assertThat(fact.factorial(4), is(24));
		assertThat(fact.factorial(5), is(120));
	}

}
