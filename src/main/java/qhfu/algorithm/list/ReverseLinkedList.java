package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
	ListNode p = null;
	ListNode p2 = head;
	while (p2 != null) {
	    ListNode p3 = p2.next;
	    p2.next = p;
	    p = p2;
	    p2 = p3;
	}
	return p;
    }
}
