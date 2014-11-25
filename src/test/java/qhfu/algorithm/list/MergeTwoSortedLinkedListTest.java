package qhfu.algorithm.list;

import org.junit.*;

import qhfu.datastructure.ListNode;

public class MergeTwoSortedLinkedListTest {

    @Test
    public void testOneEmptyList() {
	ListNode list1 = null;
	ListNode list2 = ListUtils.buildListFromArray(new int[] { 1, 3, 5 });
	MergeTwoSortedLinkedList instance = new MergeTwoSortedLinkedList();
	ListNode l3 = instance.merge(list1, list2);
	Assert.assertEquals(ListUtils.toString(l3), "1->3->5");
    }
    
    @Test
    public void testOneEmptyList2() {
	ListNode list2 = null;
	ListNode list1 = ListUtils.buildListFromArray(new int[] { 1, 3, 5 });
	MergeTwoSortedLinkedList instance = new MergeTwoSortedLinkedList();
	ListNode l3 = instance.merge(list1, list2);
	Assert.assertEquals(ListUtils.toString(l3), "1->3->5");
    }
    
    @Test
    public void testAddTwoNonEmptyList(){
	ListNode list1 = ListUtils.buildListFromArray(new int[] { 2, 4, 6 });;
	ListNode list2 = ListUtils.buildListFromArray(new int[] { 1, 3, 5 });
	MergeTwoSortedLinkedList instance = new MergeTwoSortedLinkedList();
	ListNode l3 = instance.merge(list1, list2);
	Assert.assertEquals(ListUtils.toString(l3), "1->2->3->4->5->6");
    }
    
    @Test
    public void testAddTwoEmptyList(){
	ListNode list1 = null;
	ListNode list2 = null;
	MergeTwoSortedLinkedList instance = new MergeTwoSortedLinkedList();
	ListNode l3 = instance.merge(list1, list2);
	Assert.assertEquals(ListUtils.toString(l3), "");
    }
}
