package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class ReorderList {
    /**
     * reverse the second half and merge two list,
     * 
     * @param head
     */
    public void reorderList(ListNode head) {
	if (head == null || head.next == null || head.next.next == null) {
	    return;
	}
	ListNode p1 = head;
	ListNode p2 = head;
	while (p2 != null && p2.next != null) {
	    p1 = p1.next;
	    p2 = p2.next.next;
	}
	ListNode pSecond = p1.next;
	p1.next = null;
	merge(head, reverse(pSecond));
    }

    private void merge(ListNode h1, ListNode h2) {
	ListNode helper = h1;
	h1 = h1.next;
	boolean isOdd = false;
	while (h1 != null && h2 != null) {
	    if (isOdd) {
		helper.next = h1;
		h1 = h1.next;
	    } else {
		helper.next = h2;
		h2 = h2.next;
	    }
	    helper = helper.next;
	    isOdd = !isOdd;
	}
	// don't forget to add the tail in fisrt half.
	if (h1 != null) {
	    helper.next = h1;
	}
    }

    private ListNode reverse(ListNode head) {
	ListNode p0 = null;
	ListNode p1 = head;
	while (p1 != null) {
	    ListNode p2 = p1.next;
	    p1.next = p0;
	    p0 = p1;
	    p1 = p2;
	}
	return p0;
    }

    /**
     * recursive the order the list O(n^2), <b>leet code time limit exceed</b>
     * 
     * @param head
     */
    public void reorderList2(ListNode head) {
	ListNode p = head;
	if (p == null || p.next == null || p.next.next == null) {
	    return;
	}
	if (p != null) {
	    ListNode p2 = p.next;
	    ListNode last = getLast(p);
	    p.next = last;
	    last.next = p2;
	    reorderList2(p2);
	}
    }

    private ListNode getLast(ListNode p) {
	ListNode p2 = p;
	while (p2.next != null) {
	    p = p2;
	    p2 = p2.next;
	}
	p.next = null;
	return p2;
    }
}
