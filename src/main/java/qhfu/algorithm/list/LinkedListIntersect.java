package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class LinkedListIntersect {
    public boolean isIntersect(final ListNode l1, final ListNode l2) {
	ListNode p1 = LinkedListCycle.findNodeInCycle(l1);
	ListNode p2 = LinkedListCycle.findNodeInCycle(l2);

	// both non cycle
	if (p1 == null && p2 == null) {
	    return LinkedListCycle.findIntersect(l1, l2) != null;
	} else if (p1 != null && p2 != null) { // both have cycle ,check if p2
					       // in cycle of l1
	    ListNode p3 = p1;
	    do {
		if (p3 == p2) {
		    return true;
		}
		p3 = p3.next;
	    } while (p3 != p1);
	    return false;
	} else {
	    return false;
	}
    }
}
