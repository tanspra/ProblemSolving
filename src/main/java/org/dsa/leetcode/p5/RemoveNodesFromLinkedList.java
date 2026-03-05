package org.dsa.leetcode.p5;

import org.dsa.util.ListNode;
import org.dsa.util.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
        ListNode listNode = new RemoveNodesFromLinkedList().removeNodes(head);
        ListNodeUtil.printList(listNode);
    }

    private ListNode removeNodes(ListNode head) {
        ListNode temp1= head, temp2 = null;
        while(temp1 != null){
            temp2 = temp1.next;
            while(temp2 != null){
                if(temp1!= null && temp1.val < temp2.val){
                    temp1 = temp1.next;
                    break;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return head;
    }

    public ListNode removeNodes2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            while(!stack.isEmpty() && stack.peek() < head.val){
                 stack.pop();
             }
                 stack.push(head.val);
                 head = head.next;
        }
            List<Integer> list = stack.stream().toList();
            ListNode temp = new ListNode();
            head = temp;
            for(int val : list){
                temp.next = new ListNode(val);
                temp = temp.next;
            }
            return head.next;
    }
}
