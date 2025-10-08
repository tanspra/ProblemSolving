package org.dsa.leetcode.p1;

import com.leetcode.util.ListNode;
import com.leetcode.util.ListNodeUtil;

public class RotateList {
  public static void main(String[] args) {
    ListNode node5 = new ListNode(5);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode head = new ListNode(1, node2);
    ListNodeUtil.printList(head);
    head = new RotateList().rotateRight(head, 2);
    ListNodeUtil.printList(head);
  }
  
  public ListNode rotateRight(ListNode head, int k) {
    int size = getSizeOfListNode(head) +1;
    k = k % size;
    for (int i = 0; i < k; i++) {
      head = rotate(head);
    }
    return head;
  }
  
  private int getSizeOfListNode(ListNode head) {
    ListNode temp = head;
    int size = 0;
    if(temp == null){
      return size;
    }else{
      while(temp.next != null){
        temp = temp.next;
        size++;
      }
    }
    return size;
  }
  
  
  private ListNode rotate(ListNode head) {
    ListNode temp = head;
    if (temp == null) {
      return null;
    }
    if(temp.next == null){
      return temp;
    }else {
      while (temp.next != null && temp.next.next != null) {
        temp = temp.next;
      }
      int tempVal = temp.next.val;
      temp.next = null;
      ListNode newHead = new ListNode(tempVal, head);
      return newHead;
    }
  }
}
