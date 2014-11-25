package qhfu.algorithm.list;

import java.util.Comparator;
import java.util.PriorityQueue;

import qhfu.datastructure.ListNode;

public class MergeKSortedLinkedList {

    /**
     * O(sum(n)*k)
     * 
     * @param lists
     * @return
     */
    public ListNode mergeK(ListNode[] lists) {
	ListNode dummy = new ListNode(-1, null);
	ListNode p = dummy;
	while (true) {
	    int k = -1;
	    for (int i = 0; i < lists.length; i++) {
		if (lists[i] != null
			&& (k == -1 || lists[i].val < lists[k].val)) {
		    k = i;
		}
	    }
	    if (k == -1) {
		break;
	    }
	    p.next = lists[k];
	    p = p.next;
	    lists[k] = lists[k].next;
	}
	return dummy.next;
    }

    /**
     * N(sum(n)*log(k))
     * 
     * @param lists
     * @return
     */
    public ListNode mergeK2(ListNode[] lists) {
	ListNode dummy = new ListNode(-1, null);
	ListNode p = dummy;
	PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>(10,
		new ListNodeComparator());
	for (int i = 0; i < lists.length; i++) {
	    if (lists[i] != null) {
		pqueue.add(lists[i]);
	    }
	}

	while (!pqueue.isEmpty()) {
	    ListNode min = pqueue.poll();
	    p.next = min;
	    p = p.next;
	    if (min.next != null) {
		pqueue.add(min.next);
	    }
	}
	return dummy.next;
    }

    private static class ListNodeComparator implements Comparator<ListNode> {

	@Override
	public int compare(ListNode node1, ListNode node2) {
	    return node1.val - node2.val;
	}
    }
}
