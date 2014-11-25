package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
	// check invalid input
	if (head == null || n <= 0) {
	    return head;
	}
	
	ListNode dummy = new ListNode(-1);
	dummy.next = head;
	//p1.next = head;
	ListNode p1 = dummy;
	ListNode p2 = head;
	
	// move n steps forwards for p2
	while (n > 0) {
	    if (p2 != null) {
		p2 = p2.next;
		--n;
	    } else {
		// no enough elements in list
		break;
	    }
	}
	
	// not enough elements in list
	if (n >0) {
	    return head;
	}
	// when p2 == null, we want to delete node p1.next
	while (p2 != null) {
	    p1 = p1.next;
	    p2 = p2.next;
	}
	p1.next = p1.next.next;
	return dummy.next;
    }
}
