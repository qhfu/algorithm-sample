package qhfu.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import qhfu.datastructure.ListNode;

public class LinkedListCycleTest {

    @Test
    public void testEmptyList() {
	ListNode list = null;
	LinkedListCycle llc = new LinkedListCycle();
	Assert.assertFalse(llc.hasCycle(list));
	Assert.assertNull(llc.firstNodeOfCycle(list));
	Assert.assertNull(llc.firstNodeOfCycle2(list));
    }

    @Test
    public void testSingleNodeList() {
	ListNode list = new ListNode(2, null);
	LinkedListCycle llc = new LinkedListCycle();
	Assert.assertFalse(llc.hasCycle(list));
	Assert.assertNull(llc.firstNodeOfCycle(list));
	Assert.assertNull(llc.firstNodeOfCycle2(list));
    }

    @Test
    public void testTwoNodeNonCycleList() {
	ListNode list = ListUtils.buildListFromArray(new int[] { 1, 2 });
	LinkedListCycle llc = new LinkedListCycle();
	Assert.assertFalse(llc.hasCycle(list));
	Assert.assertNull(llc.firstNodeOfCycle(list));
	Assert.assertNull(llc.firstNodeOfCycle2(list));
    }

    @Test
    public void testTwoNodeCycleList() {
	ListNode list = ListUtils.buildListFromArray(new int[] { 1, 2 });
	list.next.next = list;
	LinkedListCycle llc = new LinkedListCycle();
	Assert.assertTrue(llc.hasCycle(list));
	Assert.assertEquals(1, llc.firstNodeOfCycle(list).val);
	Assert.assertEquals(1, llc.firstNodeOfCycle2(list).val);
    }

    @Test
    public void testMultiNodeCycleList() {
	ListNode list = ListUtils
		.buildListFromArray(new int[] { 1, 2, 3, 4, 5 });
	list.next.next.next.next.next = list.next.next;
	LinkedListCycle llc = new LinkedListCycle();
	Assert.assertTrue(llc.hasCycle(list));
	Assert.assertEquals(3, llc.firstNodeOfCycle(list).val);
	Assert.assertEquals(3, llc.firstNodeOfCycle2(list).val);
    }
}
