package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

/**
 * 
 * {@see <a href=
 * "https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/"
 * >Remove Duplicates from Sorted List II</a>}
 * 
 * @author qhfu
 * 
 */
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
	// null or single node list check
	if (head == null || head.next == null) {
	    return head;
	}

	ListNode dummy = new ListNode(-1);
	ListNode cur = dummy;
	ListNode p = head.next;
	int cnt = 1;
	ListNode nodeToAdd = head;
	while (p != null) {
	    if (p.val != nodeToAdd.val) {
		if (cnt == 1) {
		    cur.next = nodeToAdd;
		    cur = cur.next;
		}
		nodeToAdd = p;
		cnt = 1;
	    } else {
		cnt++;
	    }
	    p = p.next;
	}
	// the last one
	if (cnt == 1) {
	    cur.next = nodeToAdd;
	    cur = cur.next;
	}
	cur.next = null;
	return dummy.next;
    }
}
