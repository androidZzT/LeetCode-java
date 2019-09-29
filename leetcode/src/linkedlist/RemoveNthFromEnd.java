package linkedlist;

public class RemoveNthFromEnd {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode result = removeNthFromEnd(head, 2);
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = head;
		int length = 0;
		while (first != null) {
			length++;
			first = first.next;
		}
		
		length -= n;
		first = dummy;
		while (length > 0) {
			length --;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}
}
