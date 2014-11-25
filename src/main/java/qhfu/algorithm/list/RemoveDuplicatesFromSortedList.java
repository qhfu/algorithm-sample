package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

/**
 * 
 * {@see <a
 * href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/"
 * >Remove Duplicates from Sorted List</a>}
 * 
 * @author qhfu
 * 
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleleDuplicates(ListNode h) {
	if (h == null || h.next == null) {
	    return h;
	}
	ListNode dummy = new ListNode(-1, null);
	dummy.next = h;
	ListNode p = h.next;
	// the last elements of result, head alwasy part of the result
	ListNode cur = h;
	while (p != null) {
	    // add new elements to result if not equals to the last in current
	    // result
	    if (p.val != cur.val) {
		cur.next = p;
		cur = p;
	    }
	    p = p.next;
	}
	// next of last elements should be null
	cur.next = null;
	return dummy.next;
    }
}
