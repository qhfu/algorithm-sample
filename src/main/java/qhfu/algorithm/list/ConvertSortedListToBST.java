package qhfu.algorithm.list;

import qhfu.datastructure.ListNode;
import qhfu.datastructure.TreeNode;

/**
 * @leetcode
 * @author qifu
 * 
 */
public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
	return sortedListToBST(head, getLen(head));
    }

    private TreeNode sortedListToBST(ListNode head, int len) {
	if (len == 0) {
	    return null;
	}
	if (len == 1) {
	    return new TreeNode(head.val);
	}

	ListNode mid = head;
	for (int i = 0; i < (len + 1) / 2 - 1; i++) {
	    mid = mid.next;
	}
	TreeNode result = new TreeNode(mid.val);
	result.left = sortedListToBST(head, (len + 1) / 2 - 1);
	result.right = sortedListToBST(mid.next, len - (len + 1) / 2);
	return result;
    }

    private int getLen(ListNode head) {
	int len = 0;
	while (head != null) {
	    len++;
	    head = head.next;
	}
	return len;
    }
}
