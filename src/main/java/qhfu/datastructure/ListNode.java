package qhfu.datastructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
	this.val = val;
    }

    public ListNode(int val, ListNode next) {
	this.val = val;
	this.next = next;
    }

    public int length() {
	ListNode p = this;
	int len = 0;
	while (p != null) {
	    len++;
	    p = p.next;
	}
	return len;
    }
}