package com.main.linkedlist;

// 정수를 저장하는 연결 리스트.
public class ListNode {

	private int data;
	private ListNode next;
	
	public ListNode(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
}
