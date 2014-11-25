package qhfu.algorithm.list;

import org.junit.Test;
import org.junit.Assert;

import qhfu.datastructure.ListNode;

public class LinkedListIntersectTest {

    @Test
    public void testTwoEmptyList() {
	ListNode l1 = null;
	ListNode l2 = null;
	LinkedListIntersect lli = new LinkedListIntersect();
	Assert.assertFalse(lli.isIntersect(l1, l2));
    }

    @Test
    public void testTwoListIntersect() {
	ListNode l3 = new ListNode(3, null);
	ListNode l1 = new ListNode(1, l3);
	ListNode l2 = new ListNode(2, l3);
	LinkedListIntersect lli = new LinkedListIntersect();
	Assert.assertTrue(lli.isIntersect(l1, l2));
    }

    @Test
    public void testTwoListIntersectOneCycle() {
	ListNode l3 = new ListNode(3, null);
	ListNode l1 = new ListNode(1, l3);
	l3.next = l1;
	ListNode l2 = new ListNode(2, null);
	LinkedListIntersect lli = new LinkedListIntersect();
	Assert.assertFalse(lli.isIntersect(l1, l2));
    }

    @Test
    public void testTwoListIntersectTwoCycle() {
	ListNode l4 = new ListNode(4, null);
	ListNode l3 = new ListNode(3, l4);
	ListNode l1 = new ListNode(1, l3);
	l4.next = l1;
	ListNode l2 = new ListNode(2, l3);
	LinkedListIntersect lli = new LinkedListIntersect();
	Assert.assertTrue(lli.isIntersect(l1, l2));
    }
}
