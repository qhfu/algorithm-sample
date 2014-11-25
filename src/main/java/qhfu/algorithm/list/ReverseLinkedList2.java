package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

/**
 * from leet code: <a
 * href="https://oj.leetcode.com/problems/reverse-linked-list-ii/"> reverse
 * linked list ii</a>
 * 
 * @author qhfu
 * 
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
	ListNode p = head;
	ListNode ans = new ListNode(-1);
	ans.next = head;
	ListNode pre = ans;
	int step = n - m; // calculate nodes to be reverse

	// Step 1. move p to the start node of sub list to be reverse, pre is
	// the previous node of the start node in sub list to be reverse
	while (m > 1) {
	    p = p.next;
	    m--;
	    pre = pre.next;
	}

	// Step 2 reverse the sub list
	ListNode p1 = p;
	ListNode p2 = p.next;
	while (p2 != null && step > 0) {
	    ListNode p3 = p2.next;
	    p2.next = p1;
	    p1 = p2;
	    p2 = p3;
	    step--;
	}
	// after the loop, p1 is head of sub list, p is the tail of sub list, p2
	// is next node to be reverse

	// Step 3 append the sub list to the tail of part 1
	pre.next = p1;

	// Step 4 paeend the rest of nodes to the tail of sub list
	p.next = p2;

	return ans.next;
    }
}
