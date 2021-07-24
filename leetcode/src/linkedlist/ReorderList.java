package linkedlist;

/**
 * 重排链表
 * 
 * 1 -> 2 -> 3
 * 1    2    3
 * 1 -> 3 -> 2
 * 
 * 
 * 1 -> 2 -> 3 -> 4 -> 5
 * 1    2 -> 3 -> 4    5
 * 1 -> 5 -> 2 -> 3 -> 4
 * 1 -> 5 -> 2 -> 4 -> 3
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);

        ListNode result = reorderList(head);
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
    }

    private static ListNode reorderList(ListNode node) {
        if (node == null || node.next == null || node.next.next == null) return node;
        ListNode head = node;
        ListNode next = head.next;
        while (node.next.next != null) {
            node = node.next;
        }
        ListNode tail = node.next;
        node.next = null; //与尾部断开
        head.next = tail; 
        tail.next = reorderList(next);
        return head;
    }
}
