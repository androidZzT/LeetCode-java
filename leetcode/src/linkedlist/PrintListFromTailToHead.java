package linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值
 * @author Android_ZzT
 *
 */
public class PrintListFromTailToHead {
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return null;
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> resultList = new ArrayList();
        ListNode cur = listNode;
        while(cur.next != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while(!stack.isEmpty()) {
        	resultList.add(stack.pop());
        }
        return resultList;
    }
}
