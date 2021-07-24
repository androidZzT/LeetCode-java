package linkedlist;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 提示：
    链表中节点数目为 n
    1 <= n <= 500
    -500 <= Node.val <= 500
    1 <= left <= right <= n
 */
public class ReverseNodeBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(head, 2, 4);
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        //1. 找到 left 的前一节点，赋值给 start
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        //2. 反转 [left - right] 节点
        ListNode reverseHead = start.next;
        ListNode prev = null;
        ListNode next = null;
        for (int i=0; i < right - left + 1; i++) {
            next = reverseHead.next;
            reverseHead.next = prev;
            prev = reverseHead;
            reverseHead = next;
        }
        //3. 此时，start.next.next 是反转后的尾节点，head 为反转断裂处的下一节点，prev 为反转后的头节点
        //将断裂处串联
        start.next.next = reverseHead;
        start.next = prev;
        return dummy.next;
    }
}
