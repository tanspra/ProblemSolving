package org.dsa.leetcode.p1;

import org.dsa.util.ListNode;

public class SortList {
  
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    
    //divide the listNode
    ListNode mid = getMiddle(head);
    ListNode right = mid.next;
    mid.next = null;
    
    //sort the left node
    ListNode l1 = sortList(head);
    
    //sort the right node
    ListNode l2 = sortList(right);
    
    //merge the sorted left and right node
    return mergeSortedList(l1, l2);
  }
  
  private ListNode getMiddle(ListNode head) {
    ListNode slow = head, fast = head, prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    return prev == null ? head : prev;
  }
  
  private ListNode mergeSortedList(ListNode l1, ListNode l2){
    if( l1 == null ) return l2;
    if( l2 == null ) return l1;
    
    if(l1.val < l2.val){
      l1.next = mergeSortedList(l1.next, l2);
      return l1;
    }else{
      l2.next = mergeSortedList(l1, l2.next);
      return l2;
    }
  }
  
}
