package qhfu.algorithm.list;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import qhfu.datastructure.ListNode;
import qhfu.utils.FileReaderUtils;
import qhfu.utils.StringUtils;

public class TestSortList {

    @Test
    public void testMergeSort() {
	List<String> strs = FileReaderUtils
		.getLinesFromFile("sortListInput1.txt");
	int[] data = StringUtils.toIntArray(strs.get(0), ",");
	ListNode head = ListUtils.buildListFromArray(data);
	SortList sl = new SortList();
	ListNode ans = sl.sortList(head);
	Assert.assertTrue(ListUtils.isInc(ans));
    }

    @Test
    public void testInsertSort() {
	ListNode list = ListUtils.buildListFromArray(new int[] { 3, 2, 6, 1, 2,
		4 });
	SortList sl = new SortList();
	ListNode ans = sl.sortList(list);
	Assert.assertEquals("1->2->2->3->4->6", ListUtils.toString(ans));
    }

    @Test
    public void testInsertSort2() {
	ListNode list = ListUtils.buildListFromArray(new int[] { 1 });
	SortList sl = new SortList();
	ListNode ans = sl.sortList(list);
	Assert.assertEquals("1", ListUtils.toString(ans));
    }

    @Test
    public void testInsertSort3() {
	ListNode list = ListUtils.buildListFromArray(new int[] { 5, 4, 3, 2, 1,
		0 });
	SortList sl = new SortList();
	ListNode ans = sl.sortList(list);
	Assert.assertEquals("0->1->2->3->4->5", ListUtils.toString(ans));
    }

    @Test
    public void testInsertSort4() {
	ListNode list = ListUtils.buildListFromArray(new int[] { 3, 3, 3, 3, 2,
		2, 3, 3, 3, 2, 3, 2 });
	SortList sl = new SortList();
	ListNode ans = sl.sortList(list);
	Assert.assertEquals("2->2->2->2->3->3->3->3->3->3->3->3",
		ListUtils.toString(ans));
    }
}
