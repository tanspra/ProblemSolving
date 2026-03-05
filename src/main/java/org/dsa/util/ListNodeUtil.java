package org.dsa.util;

public class ListNodeUtil {
  
  public static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val);
      if (current.next != null) {
        System.out.print(" -> ");
      }
      current = current.next;
    }
    System.out.println(); // Move to the next line after printing the list
  }
}


