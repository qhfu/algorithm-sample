package qhfu.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import qhfu.datastructure.ListNode;

public class ReverseLinkedListTest {

    @Test
    public void testEmptyList() {
	ListNode empty = null;
	ReverseLinkedList instance = new ReverseLinkedList();
	ListNode ans = instance.reverse(empty);
	Assert.assertEquals(ListUtils.toString(ans), "");
    }

    @Test
    public void testOneNodeList() {
	ListNode oneNode = new ListNode(3, null);
	ReverseLinkedList instance = new ReverseLinkedList();
	ListNode ans = instance.reverse(oneNode);
	Assert.assertEquals("3", ListUtils.toString(ans));
    }

    @Test
    public void testTwoNodeList() {
	ListNode twoNode = ListUtils.buildListFromArray(new int[] { 2, 3 });
	ReverseLinkedList instance = new ReverseLinkedList();
	ListNode ans = instance.reverse(twoNode);
	Assert.assertEquals("3->2", ListUtils.toString(ans));
    }
    
    @Test
    public void testMultiNodeList() {
	ListNode multiNode = ListUtils.buildListFromArray(new int[] { 1, 2, 3,4,5 });
	ReverseLinkedList instance = new ReverseLinkedList();
	ListNode ans = instance.reverse(multiNode);
	Assert.assertEquals("5->4->3->2->1", ListUtils.toString(ans));
    }
}
