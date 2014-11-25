package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	if (l1 == null) {
	    return l2;
	}
	if (l2 == null) {
	    return l1;
	}
	ListNode ans = new ListNode(-1);
	ListNode p = ans;
	int val = 0;
	while (l1 != null && l2 != null) {
	    val = l1.val + l2.val + val;
	    p.next = new ListNode(val % 10);
	    val = val / 10;
	    l1 = l1.next;
	    l2 = l2.next;
	    p = p.next;
	}

	while (l1 != null) {
	    val = l1.val + val;
	    p.next = new ListNode(val % 10);
	    val = val / 10;
	    l1 = l1.next;
	    p = p.next;
	}
	while (l2 != null) {
	    val = l2.val + val;
	    p.next = new ListNode(val % 10);
	    val = val / 10;
	    l2 = l2.next;
	    p = p.next;
	}
	if (val > 0) {
	    p.next = new ListNode(val);
	}
	return ans.next;
    }
}
