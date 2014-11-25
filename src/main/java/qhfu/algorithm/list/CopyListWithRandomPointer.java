package qhfu.algorithm.list;

import qhfu.datastructure.RandomListNode;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
	if (head == null) {
	    return head;
	}

	RandomListNode p = head;
	// Step 1, build a copy of list, insert next to original node
	while (p != null) {
	    RandomListNode p2 = new RandomListNode(p.label);
	    RandomListNode p3 = p.next;
	    p.next = p2;
	    p2.next = p3;
	    p = p3;
	}

	// Step 2, construct the random node
	p = head;
	while (p != null && p.next != null) {
	    RandomListNode p2 = p.next;
	    if (p.random != null) {
		p2.random = p.random.next;
	    }
	    p = p.next.next;
	}

	// Step 3, create result list
	RandomListNode ans = head.next;
	p = head;
	RandomListNode p2 = ans;
	while (p != null && p2 != null) {
	    p.next = p2.next;
	    p = p.next;
	    if (p != null) {
		p2.next = p.next;
		p2 = p2.next;
	    }
	}
	return ans;
    }
}
