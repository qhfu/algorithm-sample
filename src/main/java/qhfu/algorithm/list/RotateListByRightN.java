package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class RotateListByRightN {
    public ListNode rotateRight(ListNode head, int n) {
	if (head == null || head.next == null) {
	    return head;
	}

	// 1. calculate the list length, and store the last node
	int len = 1;
	ListNode p = head;
	while (p.next != null) {
	    len++;
	    p = p.next;
	}

	// 2. calculate how much node to rolate right
	n = n % len;
	// 3. answer tail node is n-th node
	n = len - n;

	// 4. tail node is the origin tail, no rotate required
	if (n == len) {
	    return head;
	}

	// 5. find the tail node
	ListNode tail = head;
	for (int i = 0; i < n - 1; i++) {
	    tail = tail.next;
	}
	// 6.1 build the answer node(new head) and broke the list by setting
	// next = null
	ListNode ans = tail.next;
	tail.next = null;

	// 6.2 connect the original tail and head
	p.next = head;
	return ans;
    }
}
