package qhfu.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import qhfu.datastructure.ListNode;

public class MergeKSortedLinkedListTest {

    @Test
    public void testMergeThreeSortedList() {
	ListNode l1 = ListUtils.buildListFromArray(new int[] { 1, 3, 5 });
	ListNode l2 = ListUtils.buildListFromArray(new int[] { 2, 4, 6 });
	ListNode l3 = ListUtils.buildListFromArray(new int[] { 3, 5, 7 });
	MergeKSortedLinkedList instance = new MergeKSortedLinkedList();
	ListNode l4 = instance.mergeK(new ListNode[] { l1, l2, l3 });
	Assert.assertEquals(ListUtils.toString(l4), "1->2->3->3->4->5->5->6->7");
    }

    @Test
    public void testMergeFourSortedList() {
	ListNode l1 = ListUtils.buildListFromArray(new int[] { 1, 3, 5 });
	ListNode l2 = ListUtils.buildListFromArray(new int[] { 2, 4, 6 });
	ListNode l3 = ListUtils.buildListFromArray(new int[] { 3, 5, 7 });
	ListNode l4 = null;
	MergeKSortedLinkedList instance = new MergeKSortedLinkedList();
	ListNode l5 = instance.mergeK(new ListNode[] { l1, l2, l3, l4 });
	Assert.assertEquals(ListUtils.toString(l5), "1->2->3->3->4->5->5->6->7");
    }

    @Test
    public void testMergeFourNullSortedList() {
	ListNode l1 = null;
	ListNode l2 = null;
	ListNode l3 = null;
	ListNode l4 = null;
	MergeKSortedLinkedList instance = new MergeKSortedLinkedList();
	ListNode l5 = instance.mergeK(new ListNode[] { l1, l2, l3, l4 });
	Assert.assertEquals(ListUtils.toString(l5), "");
    }

    @Test
    public void testMergeFourSortedListPartNull() {
	ListNode l1 = ListUtils.buildListFromArray(new int[] { 1, 3, 5 });
	ListNode l2 = null;
	ListNode l3 = ListUtils.buildListFromArray(new int[] { 3, 5, 7 });
	ListNode l4 = null;
	MergeKSortedLinkedList instance = new MergeKSortedLinkedList();
	ListNode l5 = instance.mergeK(new ListNode[] { l1, l2, l3, l4 });
	Assert.assertEquals(ListUtils.toString(l5), "1->3->3->5->5->7");
    }
    
    @Test
    public void testMerge2ThreeSortedList() {
	ListNode l1 = ListUtils.buildListFromArray(new int[] { 1, 3, 5 });
	ListNode l2 = ListUtils.buildListFromArray(new int[] { 2, 4, 6 });
	ListNode l3 = ListUtils.buildListFromArray(new int[] { 3, 5, 7 });
	MergeKSortedLinkedList instance = new MergeKSortedLinkedList();
	ListNode l4 = instance.mergeK2(new ListNode[] { l1, l2, l3 });
	Assert.assertEquals(ListUtils.toString(l4), "1->2->3->3->4->5->5->6->7");
    }

    @Test
    public void testMerge2FourSortedList() {
	ListNode l1 = ListUtils.buildListFromArray(new int[] { 1, 3, 5 });
	ListNode l2 = ListUtils.buildListFromArray(new int[] { 2, 4, 6 });
	ListNode l3 = ListUtils.buildListFromArray(new int[] { 3, 5, 7 });
	ListNode l4 = null;
	MergeKSortedLinkedList instance = new MergeKSortedLinkedList();
	ListNode l5 = instance.mergeK2(new ListNode[] { l1, l2, l3, l4 });
	Assert.assertEquals(ListUtils.toString(l5), "1->2->3->3->4->5->5->6->7");
    }

    @Test
    public void testMerge2FourNullSortedList() {
	ListNode l1 = null;
	ListNode l2 = null;
	ListNode l3 = null;
	ListNode l4 = null;
	MergeKSortedLinkedList instance = new MergeKSortedLinkedList();
	ListNode l5 = instance.mergeK2(new ListNode[] { l1, l2, l3, l4 });
	Assert.assertEquals(ListUtils.toString(l5), "");
    }

    @Test
    public void testMerge2FourSortedListPartNull() {
	ListNode l1 = ListUtils.buildListFromArray(new int[] { 1, 3, 5 });
	ListNode l2 = null;
	ListNode l3 = ListUtils.buildListFromArray(new int[] { 3, 5, 7 });
	ListNode l4 = null;
	MergeKSortedLinkedList instance = new MergeKSortedLinkedList();
	ListNode l5 = instance.mergeK2(new ListNode[] { l1, l2, l3, l4 });
	Assert.assertEquals(ListUtils.toString(l5), "1->3->3->5->5->7");
    }
}
