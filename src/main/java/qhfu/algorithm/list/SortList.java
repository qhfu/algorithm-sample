package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

/**
 * use merge sort to sort linked list
 * 
 * @author qhfu
 * 
 */
public class SortList {
    public ListNode sortList(ListNode head) {
	int len = getLen(head);
	return mergeSort(head, len);
    }

    public ListNode mergeSort(ListNode head) {
	if (head == null || head.next == null) {
	    return head;
	}
	ListNode p = head;
	ListNode p2 = head;
	while (p2.next != null && p2.next.next != null) {
	    p2 = p2.next;
	    p2 = p2.next;
	    p = p.next;
	}
	ListNode m2 = p.next;
	p.next = null;
	ListNode left = mergeSort(head);
	ListNode right = mergeSort(m2);
	return merge(left, right);
    }

    private int getLen(ListNode head) {
	int len = 0;
	while (head != null) {
	    head = head.next;
	    len++;
	}
	return len;
    }

    private ListNode mergeSort(ListNode head, int len) {
	if (len <= 1) {
	    return head;
	}
	int m = (len + 1) / 2 - 1;
	ListNode p = head;
	for (int i = 0; i < m; i++) {
	    p = p.next;
	}
	ListNode r = p.next;
	p.next = null;
	ListNode left = mergeSort(head, (len + 1) / 2);
	ListNode right = mergeSort(r, len - (len + 1) / 2);
	return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
	ListNode p = new ListNode(-1);
	ListNode ans = p;
	while (left != null && right != null) {
	    if (left.val < right.val) {
		p.next = left;
		left = left.next;
	    } else {
		p.next = right;
		right = right.next;
	    }
	    p = p.next;
	}
	if (left != null) {
	    p.next = left;
	}
	if (right != null) {
	    p.next = right;
	}
	return ans.next;
    }

    /**
     * the quick sort seems can not solve the leetcode problem, stackoverflow
     * 
     * @param head
     * @return
     */
    public ListNode quicksortList(ListNode head) {
	ListNode[] result = quickSort(head);
	return result[0];
    }

    private ListNode[] quickSort(ListNode head) {
	if (head == null || head.next == null) {
	    return new ListNode[] { head, head };
	}
	ListNode[] pNodes = partition(head);
	ListNode[] left = quickSort(pNodes[0]);
	ListNode[] right = quickSort(pNodes[2]);
	ListNode h = left[0];
	ListNode t = left[1];
	if (h == null) {
	    h = pNodes[1];
	    t = pNodes[1];
	} else {
	    t.next = pNodes[1];
	    t = pNodes[1];
	}
	if (right[0] != null) {
	    t.next = right[0];
	    t = right[1];
	}
	return new ListNode[] { h, t };
    }

    private ListNode[] partition(ListNode head) {
	ListNode left = new ListNode(-1);
	ListNode right = new ListNode(-1);
	ListNode pL = left;
	ListNode pR = right;
	ListNode p = head.next;
	while (p != null) {
	    if (p.val < head.val) {
		pL.next = p;
		pL = pL.next;
	    } else {
		pR.next = p;
		pR = pR.next;
	    }
	    p = p.next;
	}
	pL.next = null;
	pR.next = null;
	head.next = null;
	return new ListNode[] { left.next, head, right.next };
    }

    public ListNode insertionSort(ListNode head) {
	if (head == null || head.next == null) {
	    return head;
	}

	ListNode ans = head;
	ListNode p = head.next;
	while (p != null) {
	    ListNode next = p.next;
	    p.next = null;
	    ans = insert(ans, p);
	    p = next;
	}
	return ans;
    }

    private ListNode insert(ListNode head, ListNode node) {
	if (head == null) {
	    return node;
	}
	if (head.val > node.val) {
	    node.next = head;
	    return node;
	}

	ListNode p = head;
	// find the insert place
	while (p.next != null && p.next.val <= node.val) {
	    p = p.next;
	}
	// do insertion
	ListNode tmp = p.next;
	p.next = node;
	node.next = tmp;

	return head;
    }
}
