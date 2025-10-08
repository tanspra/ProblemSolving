package org.dsa.leetcode.p1;

import com.leetcode.util.ListNode;

public class PalindromLinkedList {
    //    public boolean isPalindrome(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while(head != null){
//          list.add(head.val);
//          head = head.next;
//      }
//        int initialIndex = 0, finalindex = list.size()-1;
//        while(initialIndex <= finalindex){
//            if(list.get(initialIndex) != list.get(finalindex))
//                return false;
//            initialIndex++;
//            finalindex--;
//        }
//        return true;
//    }
    public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;

    //find the mid of linked List
        ListNode slow = head ,fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
    //reverse the secondvhalf
        ListNode secondHalfStart = reverse(slow.next);
    //compare the initial and second half
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean palindrome = true;
        while (palindrome && p2 != null) {
            if (p1.val != p2.val) palindrome = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional: Restore the list
        slow.next = reverse(secondHalfStart);

        return palindrome;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
