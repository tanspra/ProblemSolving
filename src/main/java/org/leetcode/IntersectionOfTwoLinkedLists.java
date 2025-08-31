package org.leetcode;

import org.utility.ListNode;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = nodeLength(headA);
        int lengthB = nodeLength(headB);
        ListNode largerNode,smallerNode;
        int iterationVal = 0;
         if(lengthA > lengthB){
             largerNode = headA;
             smallerNode = headB;
             iterationVal = lengthA-lengthB;
         }else if(lengthA < lengthB){
             largerNode = headB;
             smallerNode = headA;
             iterationVal = lengthB-lengthA;
         }else{
             largerNode = headA;
             smallerNode = headB;
             iterationVal = lengthA-lengthB;
         }
        for(int i =0;i< iterationVal; i++){
            largerNode= largerNode.next;
        }
        while(largerNode != null && smallerNode != null){
            if(largerNode == smallerNode){
                return largerNode;
            }
            largerNode = largerNode.next;
            smallerNode =smallerNode.next;
        }
        return null;
    }
    private int nodeLength(ListNode listNode){
        ListNode temp = listNode;
        int length = 0;
        if(temp == null){
            return length;
        }
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
}

/**
 * Initial approach but failed because same element is there in list node other than intersected one
 * listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
 * here 1 is in both listNode and at 8 intersected
 *
 * public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
 *         ListNode result = new ListNode();
 *         Stack<Integer> stackA = convertListNodeToStack(headA);
 *         Stack<Integer> stackB = convertListNodeToStack(headB);
 *         while(!stackA.isEmpty() && !stackB.isEmpty()){
 *             if(stackA.peek() == stackB.peek()){
 *                 result.val= stackA.pop();
 *                 stackB.pop();
 *             }else{
 *                 return result;
 *             }
 *         }
 *         return result;
 *     }
 *     private Stack<Integer> convertListNodeToStack(ListNode listNode){
 *         Stack<Integer> stack = new Stack<>();
 *         while(listNode != null){
 *             stack.push(listNode.val);
 *             listNode = listNode.next;
 *         }
 *         return stack;
 *     }
 *
 */