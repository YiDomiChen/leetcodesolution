package utils;

public class LinkedList {
	public ListNode head;	//头指针
	public ListNode current;	//当前结点对象
	public int size;	//结点个数
	
	//初始化空链表
	public LinkedList() {
		this.head = this.current = new ListNode(Integer.MIN_VALUE);
		this.size = 0;
	}
	//定位函数
	public void index(int idx) throws Exception {
		if(idx < -1 || idx > size - 1) 
		{
			throw new Exception("参数错误！");
		}
		//说明在头结点之后操作。
		if(idx == -1) {
			return;
		}
		
		current = head.next;
		int j = 0;
		while(current != null && j < idx) {
			current = current.next;
			j++;
		}
		
		
	}
	
	public void delete(int idx) throws Exception {
		if(isEmpty()) {
			throw new Exception("链表为空，无法删除！");
		}
		if(idx < 0 || idx > this.size) {
			throw new Exception("参数错误！");
		}
		index(idx - 1);	//定位到要操作结点的前一个结点对象
		current.setNext(current.next.next);
		size--;
	}
	
	public int get(int idx) throws Exception {
		if(idx < 0 || idx > size - 1) {
			throw new Exception("参数错误！");
		}
		index(idx);
		return current.val;
	}
	
	public void insert(int idx, int val) throws Exception {
		if(idx < 0 || idx > size) {
			throw new Exception("参数错误");
		}
		index(idx - 1);//定位到要操作结点的前一个节点对象
		current.setNext(new ListNode(val, current.next));
		size++;
		
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
}
