package com.main.linkedlist;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {
	
	ListNode testNode;
	ListNode testNode2;
    ListNode newHead;
    ListNode newNode1;
    ListNode newNode2;
    ListNode newNode3;
    ListNode newNode4;
	ListNode nullNode;
	SingleLinkedList list;
	
	@Before
	public void setUp() {
		list = new SingleLinkedList();
		testNode  = new ListNode(10);
		testNode2  = new ListNode(20);
		
        newNode1 = new ListNode(11);
        newNode2 = new ListNode(22);
        newNode3 = new ListNode(33);
        newNode4 = new ListNode(44);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWrongInsertNode() {
		list.insertInLinkedList(testNode, testNode2, 0);
	}
	
	@Test
	public void testListPrint() {
//		list.printList(nullNode);
//		System.out.print("PrintTest: ");
//		list.printList(testNode);
	}

	@Test
	public void testListLength() {
		assertThat(list.listLength(nullNode), is(0));
		testNode  = new ListNode(10);
		assertThat(list.listLength(testNode), is(1));
//		System.out.println("NULL");
	}
	
	@Test
	public void testInsertList() {
		// 1. headNode == null 인 경우에 새 노드 삽입.
		newHead = list.insertInLinkedList(nullNode, newNode1, 1);
//		list.printList(newHead);
		assertThat(list.listLength(newHead), is(1));
		
		// 2. headNode != nul 이고, headNode 앞에 새 노드 삽입.
		newHead = list.insertInLinkedList(newHead, newNode2, 1);
//		list.printList(newHead);
		assertThat(list.listLength(newHead), is(2));
		
		// 3. 마지막 노드 다음에 새 노드 삽입.
		newHead = list.insertInLinkedList(newHead, newNode3, list.listLength(newHead)+1);
//		list.printList(newHead);
		assertThat(list.listLength(newHead), is(3));
		
		// 4. 중간 노드에 새 노드 삽입.
		newHead = list.insertInLinkedList(newHead, newNode4, 2);
//		list.printList(newHead);
		assertThat(list.listLength(newHead), is(4));
	}
	
	@Test
	public void testDeleteNode() {
        // 1. headNode == null 인 경우에 새 노드 삽입.
        newHead = list.insertInLinkedList(nullNode, newNode1, 1);
//      list.printList(newHead);
        assertThat(list.listLength(newHead), is(1));

        // 1. head를 삭제
        newHead = list.deleteNode(newHead, 1);  // head != null 경우
        assertThat(list.listLength(newHead), is(0));
        newHead = list.deleteNode(newHead, 1);  // head == null 경우
        assertThat(list.listLength(newHead), is(0));
        
        // 2. 마지막을 삭제
        newHead = list.insertInLinkedList(nullNode, newNode1, 1);
        newHead = list.insertInLinkedList(newHead, newNode2, 2);
        assertThat(list.listLength(newHead), is(2));
        newHead = list.deleteNode(newHead, list.listLength(newHead));
        assertThat(list.listLength(newHead), is(1));
        newHead = list.deleteNode(newHead, list.listLength(newHead));
        assertThat(list.listLength(newHead), is(0));
        
        // 3. 중간 노드를 삭제
        newHead = list.insertInLinkedList(nullNode, newNode1, 1);
        newHead = list.insertInLinkedList(newHead, newNode2, 2);
        newHead = list.insertInLinkedList(newHead, newNode3, 3);
        assertThat(list.listLength(newHead), is(3));
        list.printList(newHead);
        newHead = list.deleteNode(newHead, 2);
        assertThat(list.listLength(newHead), is(2));
        list.printList(newHead);
	}

	@Test
	public void testDeleteList() {
	    ListNode head = new ListNode(77);
	    newHead = list.insertInLinkedList(head, newNode1, 1);
	    newHead = list.insertInLinkedList(newHead, newNode2, 2);
	    newHead = list.insertInLinkedList(newHead, newNode3, 3);
	    assertThat(list.listLength(newHead), is(4));
	    list.printList(newHead);
	    list.deleteList(newHead);
	    System.gc();
	    assertThat(list.listLength(newHead), is(4));
	    list.printList(newHead);
	}
}
