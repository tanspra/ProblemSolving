package org.leetcode;

/*
* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, org.leetcode.ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        display(l1);
//        display(l2);
//        display(new AddTwoNumbers().addTwoNumbers(l1, l2));

        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        display(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }

    private static void display(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        System.out.print(listNode.val + " ");
        display(listNode.next);
        System.out.println();
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    /* This commented code is approached in correct manner but the limit if int and long size is creating issue

       int  counter1 = 0, counter2 = 0;
        long num1 = 0, num2 = 0;
        //calculating l1 number
        do {
            num1 += ((long) Math.pow(10, counter1) * l1.val);
            l1 = l1.next;
            counter1++;
        } while (l1 != null);

        //calculating l2 number
        do {
            num2 += ((long) Math.pow(10, counter2) * l2.val);
            l2 = l2.next;
            counter2++;
        } while (l2!= null);
        //calculate sum
        long sum = num1 + num2;

        //add in ListNode
        ListNode resultNode = new ListNode();
        ListNode dummyHead = resultNode;
        while (sum != 0){
            dummyHead.val = (int)sum % 10;
            sum /= 10;
            if(sum!=0) {
                dummyHead.next = new ListNode();
                dummyHead = dummyHead.next;
            }

        }

        return resultNode;
   */


        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}
