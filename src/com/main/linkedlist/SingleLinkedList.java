package com.main.linkedlist;

public class SingleLinkedList {
	
	/**
	 * 리스트의 모든 노드를 출력한다.
	 */
	public void printList(ListNode headNode) {
		ListNode newHead = headNode;
		while( newHead != null) {
			System.out.print(newHead.getData() + "->");
			newHead = newHead.getNext();
		}
		System.out.println("NULL");
	}
	
	/**
	 * 리스트 탐색하기
	 *  1. 포인터를 따라간다.
	 *  2. 탐색하면서 노드의 값을 표시한다. (또는 개수를 센다.)
	 *  3. '다음' 포인터가 NULL을 가리키면 멈춘다.
	 * @param headNode
	 * @return
	 */
	public int listLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	
	/**
	 * 단일 연결 리스트의 삽입
	 *  1. 새 노드를 '머리' 노드 포인터 앞(가장 처음)에 삽입하기
	 *  	- 새 노드의 '다음' 포인터를 현재의 '머리'를 가리키도록 수정.
	 *  	- '머리' 노드 포인터가 새 노드를 가리키도록 수정
	 *  2. 새 노드를 '꼬리' 노드 포인터 뒤(리스트 가장 끝)에 삽입하기
	 *  	- 새 노드의 '다음' 포인터는 NULL을 가리키도록 수정.
	 *  	- 마지막 노드의 '다음' 포인터는 새 노드를 가리키도록 수정.
	 *  3. 새 노드를 리스트 중간(랜덤한 위치, n번째)에 삽입하기
	 *  	- 새 노드의 '다음' 포인터가 n+1을 가리키도록 수정.
	 *  	- n 노드의 '다음' 포인터가 새 노드를 가리키도록 수정.
	 *  @return headNode를 리턴한다.
	 */
	public ListNode insertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
		if (headNode == null)	// 최초로 설정
			return nodeToInsert;
		int size = listLength(headNode);
		if (position > size + 1 || position < 1) {
			System.out.println("잘못된 삽입 위치입니다! 유효한 위치: 1~"+ (size+1));
			throw new IllegalArgumentException();
//			return headNode;
		}
		
		if (position == 1) {	// 첫 노드를 삽입한다.
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		} else {					// 중간과 끝에 노드를 삽입한다.
			ListNode previousNode = headNode;
			int count = 1;
			while (count < position - 1) {	// n번째	노드를 찾는다.
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();	// n+1번째 노드
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}
		return headNode;
	}

    public ListNode deleteNode(ListNode headNode, int position) {
        int size = listLength(headNode);
        if (position > size || position < 1) {
            System.out.println("Position of node to delete is invalid."
                    + " The value inputs are 1 to " + size);
            return headNode;
        }
        
        // [11] -> [22] -> [33]
        if (position == 1) { // 리스트 가장 앞에서 삭제
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        } else {    // 끝에 닿을 때까지 내부에서 삭제
            ListNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }

    public void deleteList(ListNode head) {
        ListNode auxiliaryNode, iterator = head;
        while (iterator != null) {
            auxiliaryNode = iterator.getNext();
            iterator = null;
            iterator = auxiliaryNode;
        }
    }
}
