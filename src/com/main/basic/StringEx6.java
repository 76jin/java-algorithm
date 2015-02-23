package com.main.basic;

public class StringEx6 {

	static char[] c = new char[0];		// 크기가 0인 char 배열 생성
	static String s = new String(c);	// == new String("")
	public static void main(String[] args) {
		System.out.println(s);				// ""l
		System.out.println(c.length);	// 0
	}
}
