package algorithm.linkedlist;

/**
 * 18.2 删除链表中重复的结点
 * 
 * @author ZhangWenGuang
 *
 */
public class Duplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(1);
		ListNode node7 = new ListNode(4);
		ListNode node8 = new ListNode(7);
		ListNode node9 = new ListNode(8);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		
		ListNode resultNode = deleteDuplication(node1);
		
		ListNode node = resultNode;
		System.out.println(resultNode.value);
		while (node.next != null) {
			node = node.next;
			System.out.println(node.value);
		}

	}
	
	public static ListNode deleteDuplication(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode next = head.next;
		
		if (head.value == next.value) {
			while (next.next != null && next.value == head.value) {
				next = next.next;
			}
			return deleteDuplication(next);
		} else {
			ListNode node = deleteDuplication(next);
			
			head.next = node;
			
			return head;
		}
	}
	
	

}

class ListNode {
	public int value;
	public ListNode next;
	
	ListNode(int value) {
		this.value = value;
	}
}
