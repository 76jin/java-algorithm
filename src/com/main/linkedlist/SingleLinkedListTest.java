package com.main.linkedlist;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {
	
	ListNode testNode;
	ListNode testNode2;
	ListNode nullNode;
	SingleLinkedList list;
	
	@Before
	public void setUp() {
		list = new SingleLinkedList();
		testNode  = new ListNode(10);
		testNode2  = new ListNode(20);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWrongInsertNode() {
		list.insertInLinkedList(testNode, testNode2, 0);
	}
	
	@Test
	public void testListPrint() {
//		list.printList(nullNode);
		System.out.print("PrintTest: ");
		list.printList(testNode);
	}

	@Test
	public void testListLength() {
		assertThat(list.listLength(nullNode), is(0));
		testNode  = new ListNode(10);
		assertThat(list.listLength(testNode), is(1));
		System.out.println("NULL");
	}
	
	@Test
	public void testInsertList() {
		ListNode newHead;
		ListNode newNode = new ListNode(11);
		
		// 1. headNode == null 인 경우에 새 노드 삽입.
		newHead = list.insertInLinkedList(nullNode, newNode, 1);
//		list.printList(newHead);
		assertThat(list.listLength(newHead), is(1));
		
		// 2. headNode != nul 이고, headNode 앞에 새 노드 삽입.
		newNode = new ListNode(22);
		newHead = list.insertInLinkedList(newHead, newNode, 1);
//		list.printList(newHead);
		assertThat(list.listLength(newHead), is(2));
		
		// 3. 마지막 노드 다음에 새 노드 삽입.
		newNode = new ListNode(33);
		newHead = list.insertInLinkedList(newHead, newNode, list.listLength(newHead)+1);
//		list.printList(newHead);
		assertThat(list.listLength(newHead), is(3));
		
		// 4. 중간 노드에 새 노드 삽입.
		newNode = new ListNode(44);
		newHead = list.insertInLinkedList(newHead, newNode, 2);
		list.printList(newHead);
		assertThat(list.listLength(newHead), is(4));
	}

}
