package qhfu.algorithm.list;

import org.junit.Test;

import qhfu.datastructure.RandomListNode;

public class CopyListWithRandomPointerTest {
    @Test
    public void testOneNode() {
	RandomListNode node = new RandomListNode(1);
	CopyListWithRandomPointer ins = new CopyListWithRandomPointer();
	RandomListNode cloned = ins.copyRandomList(node);
	System.out.println(toStr(node));
	System.out.println(toStr(cloned));
    }

    private String toStr(RandomListNode h) {
	StringBuilder sb = new StringBuilder();
	while (h != null) {
	    sb.append("->").append(h.label);
	    h = h.next;
	}
	return sb.toString();
    }

}
