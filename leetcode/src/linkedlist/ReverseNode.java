package linkedlist;

public class ReverseNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		
		ListNode result = reverseNodeRecursive(head);
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next;
		while (head != null) {
			next = head.next; // 先保存下一个节点
			head.next = prev;
			prev = head; // 整体后移
			head = next;
		}
		return prev; //返回前节点，此时 Head 已经指向末尾 Null
	}

	public static ListNode reverseNodeRecursive(ListNode head) {
		if (head.next == null)
			return head;
		ListNode last = reverseNodeRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}
}