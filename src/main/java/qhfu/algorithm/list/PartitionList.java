package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

/**
 * 
 * {@see <a href= "https://oj.leetcode.com/problems/partition-list/" >Partition
 * List</a>}
 * 
 * @author qhfu
 * 
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
	if (head == null || head.next == null) {
	    return head;
	}
	ListNode dummy1 = new ListNode(-1);
	ListNode left = dummy1;

	ListNode dummy2 = new ListNode(-1);
	ListNode right = dummy2;

	ListNode p2 = head;
	// build two list, one is elements smaller than x, other are equal or
	// larger than x
	while (p2 != null) {
	    if (p2.val < x) {
		left.next = p2;
		left = left.next;
	    } else {
		right.next = p2;
		right = right.next;
	    }
	    p2 = p2.next;
	}

	left.next = dummy2.next;
	right.next = null;
	return dummy1.next;
    }
}
