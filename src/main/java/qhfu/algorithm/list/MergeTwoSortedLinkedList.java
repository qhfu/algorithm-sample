package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class MergeTwoSortedLinkedList {

    /**
     * Merge two sorted linked list into one
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode merge(ListNode l1, ListNode l2) {
	if (l1 == null) {
	    return l2;
	}
	if (l2 == null) {
	    return l1;
	}
	ListNode dummy = new ListNode(-1, null);
	ListNode curr = dummy;
	while (l1 != null && l2 != null) {
	    if (l1.val < l2.val) {
		curr.next = l1;
		l1 = l1.next; 
	    } else {
		curr.next = l2;
		l2 = l2.next;
	    }
	    curr = curr.next;
	}
	if (l1 != null) {
	    curr.next = l1;
	}
	if (l2 != null) {
	    curr.next = l2;
	}
	return dummy.next;
    }
}
