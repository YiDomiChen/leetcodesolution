package utils;

public class ListNode {
	public int val;
	public ListNode next;
	//头结点的构造方法
	public ListNode(int x) { val = x; }
	//非头结点的构造方法
	public ListNode(int x, ListNode next) {
		this.val = x;
		this.next = next;
	}
	//获得当前结点的指针域
	public ListNode getNext() {
		return this.next;
	}
	//设置当前结点的指针域
	public void setNext(ListNode next) {
		this.next = next;
	}
}