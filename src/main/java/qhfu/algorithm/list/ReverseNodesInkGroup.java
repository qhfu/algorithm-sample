package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class ReverseNodesInkGroup {

    /**
     * soution 1, try to reverse every k-group, rollback the reverse if no
     * enough elements
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
	if (k <= 1 || head == null || head.next == null) {
	    return head;
	}
	ListNode ans = new ListNode(-1);
	ans.next = head;
	ListNode h = head;
	ListNode pre = ans;
	while (h != null) {
	    ListNode[] temp = reverseK(pre, h, k);
	    h = temp[0];
	    pre = temp[1];
	}
	return ans.next;
    }

    private ListNode[] reverseK(ListNode preTail, ListNode head, int k) {
	ListNode p1 = null;
	ListNode p2 = head;
	while (p2 != null && k > 0) {
	    k--;
	    ListNode p3 = p2.next;
	    p2.next = p1;
	    p1 = p2;
	    p2 = p3;
	}

	if (k == 0) {
	    preTail.next = p1;
	    preTail = head;
	    head.next = null;
	    return new ListNode[] { p2, preTail }; // p2 is the new head, pre is
						   // tail of current reversed
						   // list
	} else {
	    // no enough node in list, reverse the change
	    p2 = p1;
	    p1 = null;
	    while (p2 != null) {
		ListNode p3 = p2.next;
		p2.next = p1;
		p1 = p2;
		p2 = p3;
	    }
	    preTail.next = p1;
	    return new ListNode[] { null, null };
	}
    }

    /**
     * before reverse, check whether there is enough node in list
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup_2(ListNode head, int k) {
	ListNode ans = new ListNode(-1);
	ans.next = head;
	ListNode p = ans; // the previous node, of sub list going to reverse
	ListNode h = head;
	// reverse k nodes, if there are at least k nodes left
	while (hasEnoughNode(h, k)) {
	    ListNode[] triple = reverse(h, k);
	    p.next = triple[0];
	    p = triple[1];
	    h = triple[2];
	}
	return ans.next;
    }

    /**
     * at least k nodes
     * 
     * @param head
     * @param k
     * @return
     */
    private boolean hasEnoughNode(ListNode head, int k) {
	while (head != null && k > 0) {
	    head = head.next;
	    k--;
	}
	return k == 0;
    }

    /**
     * 
     * @param head
     * @param k
     * @return array of three nodes: first node of reversed list, last node of
     *         reversed list, the node next to reversed list
     */
    private ListNode[] reverse(ListNode head, int k) {
	ListNode p1 = head;
	ListNode p2 = head.next;
	while (p2 != null && k > 1) { // reverse k nodes, only need k - 1 steps
	    ListNode p3 = p2.next;
	    p2.next = p1;
	    p1 = p2;
	    p2 = p3;
	    k--;
	}
	head.next = p2;
	return new ListNode[] { p1, head, p2 };
    }
}
