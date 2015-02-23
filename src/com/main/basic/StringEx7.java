package com.main.basic;

public class StringEx7 {

	public static void main(String[] args) {
		
		int value = 100;
		String strValue = String.valueOf(value);
		
		int value2 = 100;
		String strValue2 = value2 + "";
		
		System.out.println(strValue);
		System.out.println(strValue2);

		if (strValue == strValue2)
			System.out.println("1 true");
		else
			System.out.println("1 false");
		
		if (strValue.equals(strValue2))
			System.out.println("2 true");
		else 
			System.out.println("2 false");
	}
}
