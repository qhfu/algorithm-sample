package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
	ListNode ans = new ListNode(-1);
	ListNode p = head;
	ListNode cur = ans;
	while (p != null && p.next != null) {
	    // store p2 for next iteration is very important, since the coming
	    // two steps will reset the next pointer of p
	    ListNode p2 = p.next.next;
	    cur.next = p.next;
	    cur = cur.next;
	    cur.next = p;
	    cur = cur.next;
	    p = p2;
	}
	cur.next = p;
	return ans.next;
    }
}
