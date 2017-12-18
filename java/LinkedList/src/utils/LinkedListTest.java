package utils;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testLinkedList() throws Exception {
		// TODO Auto-generated method stub
        LinkedList list = new LinkedList();
		for (int i = 0; i < 10; i++) {
			int temp = ((int) (Math.random() * 100)) % 100;
			list.insert(i, temp);
			System.out.print(temp + " ");
		}
		list.delete(4);
		System.out.println("\n------删除第五个元素之后-------");
		for (int i = 0; i < list.size; i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
