package linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(4);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(4);
		
		ListNode result = addTwoNumbers(l1, l2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;	
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int a1 = l1 == null ? 0 : l1.val;
			int a2 = l2 == null ? 0 : l2.val;
			int sum = a1 + a2 + carry;
			if (sum < 10) {
				curr.next = new ListNode(sum);
				carry = 0;
			} else {
				curr.next = new ListNode(sum - 10);
				carry = 1;
			}
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
			curr = curr.next;
		}
		if (carry > 0) curr.next = new ListNode(1);
		return dummyHead.next;
	}
}
