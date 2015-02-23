package com.main.basic;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.Before;
import org.junit.Test;

public class StringTest {
	
	private char [] c = {'H', 'e', 'l', 'l', 'o'};
	private String strByChar;
	private String strByString;
	private String strByStringBuffer;
	private String ab;
	private String s;
	private String animals;

	@Before
	public void setUp() {
		strByChar = new String(c);
		strByString = new String("Hello");
		strByStringBuffer = new String(new StringBuffer("Hello"));
		
		ab = "AABBAABB";
		s = "java.java.java";
		animals = "dog,cat,bear"; 
	}
	
	@Test
	public void StringContructorTest(){
		assertThat(strByChar, is("Hello"));
		assertThat(strByString, is("Hello"));
		assertThat(strByStringBuffer, is("Hello"));
	}
	
	@Test
	public void charAtTest() {
		assertThat(strByString.charAt(0), is('H'));
		assertThat(strByString.charAt(1), is('e'));
		assertThat(strByString.charAt(2), is('l'));
		assertThat(strByString.charAt(3), is('l'));
		assertThat(strByString.charAt(4), is('o'));
	}

	@Test
	public void concatTest() {
		assertThat(strByString.concat(" World"), is("Hello World"));
	}
	
	@Test
	public void endsWithTest() {
		assertThat(strByString.endsWith("lo"), is(true));
	}
	
	@Test
	public void equalsTest() {
		assertThat(strByString.equals("Hello"), is(true));
	}
	
	@Test
	public void equalsIgnoreCaseTest() {
		assertThat(strByString.equalsIgnoreCase("hello"), is(true));
	}
	
	@Test
	public void indexOfTest() {
		assertThat(strByString.indexOf('w'), is(-1));
		assertThat(strByString.indexOf('e'), is(1));
		assertThat(strByString.indexOf('l'), is(2));
		assertThat(strByString.indexOf('o'), is(4));
	}
	
	@Test
	public void indexOfTest2() {
		assertThat(strByString.indexOf("World"), is(-1));
		assertThat(strByString.indexOf("lo"), is(3));
	}
	
	@Test
	public void internTest() {
		assertTrue(strByString != strByStringBuffer);
		assertTrue(strByString.equals(strByStringBuffer));
		assertTrue(strByString.intern() == strByStringBuffer.intern());
	}
	
	@Test
	public void lastIndexOfTest() {
		assertThat(s.lastIndexOf("w"), is(-1));
		assertThat(s.lastIndexOf("j"), is(10));
	}
	
	@Test
	public void lastIndexOfTest2() {
		assertThat(s.lastIndexOf("World"), is(-1));
		assertThat(s.lastIndexOf("java"), is(10));
	}
	
	@Test
	public void lengthTest() {
		assertThat(strByString.length(), is(5));
	}
	
	@Test
	public void replaceTest() {
		assertThat(ab.replace('A', 'a'), is("aaBBaaBB"));
		assertThat(ab.replace("AB", "ab"), is("AabBAabB"));
		assertThat(ab.replace("A.?B", "zz"), is("AABBAABB")); // 정규식 안됨.
	}
	
	@Test
	public void replaceAllTest() {
		assertThat(ab.replaceAll("BB", "bb"), is("AAbbAAbb"));
		assertThat(ab.replaceAll("A.?B", "zz"), is("zzBzzB")); // 정규식 됨.
	}
	
	@Test
	public void replaceFirstTest() {
		assertThat(ab.replaceFirst("BB", "bb"), is("AAbbAABB"));
		assertThat(ab.replaceFirst("BB", "bb"), is(not("AAbbAAbb")));
	}
	
	@Test
	public void splitTest() {
		String[] arr = animals.split(",");
		assertThat(arr[0], is("dog"));
		assertThat(arr[1], is("cat"));
		assertThat(arr[2], is("bear"));
	}
	
	@Test
	public void splitTest2() {
		String[] arr = animals.split(",", 2);
		assertThat(arr[0], is("dog"));
		assertThat(arr[1], is("cat,bear"));
	}
	
	@Test
	public void startsWithTest() {
		assertTrue(animals.startsWith("dog"));
		assertThat(animals.startsWith("cat"), is(false));
		
		assertTrue(animals.startsWith("dog", 0));
		assertTrue(animals.startsWith("cat", 4));
		assertTrue(animals.startsWith("bear", 8));
	}
	
	@Test
	public void substringTtest() {
		assertThat(strByString.substring(0), is("Hello"));
		assertThat(strByString.substring(1), is("ello"));
		assertThat(strByString.substring(2), is("llo"));
		assertThat(strByString.substring(3), is("lo"));
		assertThat(strByString.substring(4), is("o"));
		assertThat(strByString.substring(5), is(""));
		
		assertThat(strByString.substring(1, 3), is("el"));
	}
	
	@Test
	public void toLowerCaseTest() {
		assertThat(strByString.toLowerCase(), is("hello"));
		assertThat(strByString.toLowerCase(), is(not("Hello")));
	}
	
	@Test
	public void toUpperCaseTest() {
		assertThat(strByString.toUpperCase(), is("HELLO"));
		assertThat(strByString.toUpperCase(), is(not("Hello")));
	}
	
	@Test
	public void toStringTest() {
		assertThat(strByString.toString(), is("Hello"));
		assertThat(strByString.toString(), is(not("hello")));
	}
	
	@Test
	public void trimTest() {
		String ss = "   Hello World!   ";
		assertThat(ss.trim(), is("Hello World!"));
	}
	
	@Test
	public void valueOfTest() {
		assertThat(String.valueOf(true), is("true"));
		assertThat(String.valueOf(true), is(not("false")));
		
		assertThat(String.valueOf('a'), is("a"));
		assertThat(String.valueOf('a'), is(not("b")));
		
		assertThat(String.valueOf(11), is("11"));
		assertThat(String.valueOf(11L), is("11"));
		assertThat(String.valueOf(11.0f), is("11.0"));
		assertThat(String.valueOf(11.0d), is("11.0"));
		assertThat(String.valueOf("ab"), is("ab"));
		
		assertThat(String.valueOf(this.c), is("Hello"));
		assertThat(String.valueOf(c, 0, 3), is("Hel"));
		assertThat(String.valueOf(c, 0, 3), is(not("Hello")));
		
		java.util.Date d = new java.util.Date();
		assertThat(String.valueOf(d.getYear()), is("115"));
	}

}
