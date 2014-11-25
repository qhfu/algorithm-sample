package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;

public final class ListUtils {

    public static String toString(ListNode head) {
	StringBuilder sb = new StringBuilder();
	if (head == null) {
	    return sb.toString();
	}
	sb.append(head.val);
	head = head.next;
	while (head != null) {
	    sb.append("->").append(head.val);
	    head = head.next;
	}
	return sb.toString();
    }

    /**
     * build linked list from array
     * 
     * @param array
     * @return
     */
    public static ListNode buildListFromArray(int[] array) {
	ListNode dummy = new ListNode(-1, null);
	ListNode p = dummy;
	for (int i = 0; i < array.length; i++) {
	    p.next = new ListNode(array[i], null);
	    p = p.next;
	}
	return dummy.next;
    }

    /**
     * 
     * @return true if the list in order of increasement
     */
    public static boolean isInc(ListNode head) {
	if (head == null || head.next == null) {
	    return true;
	}
	int v = head.val;
	ListNode p = head.next;
	while (p != null) {
	    if (p.val < v) {
		return false;
	    }
	    v = p.val;
	    p = p.next;
	}
	return true;
    }
}
