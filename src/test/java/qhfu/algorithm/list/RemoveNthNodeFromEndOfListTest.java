package qhfu.algorithm.list;

import org.junit.Test;
import org.junit.Assert;

import qhfu.datastructure.ListNode;

public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void testRemove1stNode() {
	ListNode l = ListUtils.buildListFromArray(new int[] { 1, 2, 3 });
	RemoveNthNodeFromEndOfList instance = new RemoveNthNodeFromEndOfList();
	ListNode ans = instance.removeNthFromEnd(l, 1);
	Assert.assertEquals("1->2", ListUtils.toString(ans));
    }

    @Test
    public void testRemove2edNode() {
	ListNode l = ListUtils.buildListFromArray(new int[] { 1, 2, 3 });
	RemoveNthNodeFromEndOfList instance = new RemoveNthNodeFromEndOfList();
	ListNode ans = instance.removeNthFromEnd(l, 2);
	Assert.assertEquals("1->3", ListUtils.toString(ans));
    }

    @Test
    public void testRemove3rdNode() {
	ListNode l = ListUtils.buildListFromArray(new int[] { 1, 2, 3 });
	RemoveNthNodeFromEndOfList instance = new RemoveNthNodeFromEndOfList();
	ListNode ans = instance.removeNthFromEnd(l, 3);
	Assert.assertEquals("2->3", ListUtils.toString(ans));
    }

    @Test
    public void testRemove4thNode() {
	ListNode l = ListUtils.buildListFromArray(new int[] { 1, 2, 3 });
	RemoveNthNodeFromEndOfList instance = new RemoveNthNodeFromEndOfList();
	ListNode ans = instance.removeNthFromEnd(l, 4);
	Assert.assertEquals("1->2->3", ListUtils.toString(ans));
    }
}
