package 链表操作.q138_复制带随机指针的链表.f1;

import java.util.HashMap;

/**
 * 用Map存储遍历过的节点，时间o(n)，额外空间o(n)
 */
public class Solution {

    HashMap<ListNode, ListNode> visitedHash = new HashMap<ListNode, ListNode>();

    public ListNode copyRandomList(ListNode head) {

        if (head == null) {
            return null;
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        ListNode listNode = new ListNode(head.val);

        this.visitedHash.put(head, listNode);
        listNode.next = this.copyRandomList(head.next);
        listNode.random = this.copyRandomList(head.random);

        return listNode;
    }
}