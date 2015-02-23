package com.main.recursive;

public class TowerOfHannoi {

	public static void main(String[] args) {
//		hannoi();
	}
	
	private void hannoi(int n, char frompeg, char topeg, char auxpeg) {
		// 원반이 하나이면, 옮기고 리턴한다.
		if (n == 1) {
			System.out.println("Move disk 1 from peg -- + frompeg + -- to peg "
					+ topeg);
			return;
		}
		// 앞의 n - 1개 원반을 C를 보조탑으로 이용해서 A에서 B로 옮긴다.
		hannoi(n - 1, frompeg, auxpeg, topeg);
		
		// 나머지 원반을 A에서 C로 옮긴다.
		System.out.println("Move disk from peg" + frompeg + " to peg "
				+ topeg);
		
		// n - 1개의 원반을 A를 보조탑으로 이용해서 B에서 C로 옮긴다.
		hannoi(n - 1, auxpeg, topeg, frompeg);
	}
	
	private void print() {
		
	}
}
