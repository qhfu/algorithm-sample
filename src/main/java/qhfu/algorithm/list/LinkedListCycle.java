package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode list) {
	return findNodeInCycle(list) != null;
    }

    public static ListNode findNodeInCycle(ListNode list) {
	if (list == null || list.next == null) {
	    return null;
	}
	ListNode p1 = list;
	ListNode p2 = list.next;
	ListNode p3 = null;
	while (p2 != null && p2.next != null) {
	    if (p1 == p2) {
		p3 = p1;
		break;
	    }
	    p1 = p1.next;
	    p2 = p2.next.next;
	}
	return p3;
    }

    /**
     * <pre>
     * {@code
     * 1. check if the node has cycle
     * 2. if has cycle, find a node p in the cycle
     * 3. set h2 = p.next, and set p.next = null
     * 4. count the length of list start from h and h2
     * 5. move p1 or p2 forwards until len1 == len2.
     * 6. step p1 and p2 at the same time
     * 7. when p1 == p2, then p3 is the first node of cycle.
     * 8, rebuild the list, and return p3
     * }
     * </pre>
     * 
     * @param list
     * @return
     */
    public ListNode firstNodeOfCycle(ListNode list) {
	ListNode p3 = findNodeInCycle(list);
	if (p3 == null) {
	    return null;
	}

	ListNode p4 = p3.next;
	p3.next = null;
	ListNode ans = findIntersect(list, p4);
	p3.next = p4;
	return ans;
    }

    public static ListNode findIntersect(final ListNode l1, final ListNode l2) {
	ListNode p1 = l1;
	ListNode p2 = l2;
	if (p1 == null || p2 == null) {
	    return null;
	}
	int len1 = p1.length();
	int len2 = p2.length();
	while (len1 > len2) {
	    p1 = p1.next;
	    len1--;
	}
	while (len2 > len1) {
	    p2 = p2.next;
	    len2--;
	}

	while (p1 != null && p2 != null) {
	    if (p1 == p2) {
		return p1;
	    }
	    p1 = p1.next;
	    p2 = p2.next;
	}
	if (p1 == null) {
	    return p2;
	} else {
	    return p1;
	}
    }

    public boolean isIntersect(final ListNode l1, final ListNode l2) {
	ListNode p1 = findNodeInCycle(l1);
	ListNode p2 = findNodeInCycle(l2);

	// both non cycle
	if (p1 == null && p2 == null) {
	    return findIntersect(l1, l2) != null;
	} else if (p1 != null && p2 != null) { // both have cycle ,check if p2
					       // in cycle of l1
	    ListNode p3 = p1.next;
	    while (p3 != p1) {
		if (p3 == p2) {
		    return true;
		}
		p3 = p3.next;
	    }
	    return false;
	} else {
	    return false;
	}
    }

    public ListNode firstNodeOfCycle2(ListNode h) {
	// Step. 1 find the cycle node
	ListNode p3 = findNodeInCycle(h);

	// Step. 2 check if the cycle exists
	if (p3 == null) {
	    return null;
	}

	// Step. 3 find the cycle length
	ListNode tmp = p3.next;
	int cnt = 1;
	while (tmp != p3) {
	    tmp = tmp.next;
	    cnt++;
	}

	// Step 4 one start from head, another start from head + cnt of cycle
	ListNode p1 = h;
	ListNode p2 = h;
	while (cnt > 0) {
	    p2 = p2.next;
	    cnt--;
	}

	// Step 5, two pointers will meeting ad beginning of cycle, steps of p2
	// = p1 + cnt of cycle
	while (p1 != p2) {
	    p1 = p1.next;
	    p2 = p2.next;
	}

	// Step 6, return the start node of cycle
	return p1;
    }
}
