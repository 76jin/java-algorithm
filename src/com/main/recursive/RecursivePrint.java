package com.main.recursive;

public class RecursivePrint {

	public static void main(String[] args) {
//		recursivePrint(1);
//		recursivePrint(2);
//		recursivePrint(3);
//		recursivePrint(4);
		recursivePrint(5);
	}

	private static void recursivePrint(int i) {
		if (i == 0) return;
		else {
			System.out.println(i);
			recursivePrint(i - 1);
		}
			
	}
}
