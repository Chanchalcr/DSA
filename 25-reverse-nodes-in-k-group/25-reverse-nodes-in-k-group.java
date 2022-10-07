/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public ListNode reverseKGroup(ListNode head, int k) {
       
         if(k==1 || head == null) return head;
        ListNode one = null;
        ListNode two = head;
        ListNode three = head.next;
        while(true) {
            int flag = 0;
            ListNode temp = two;
            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    flag = 1;
                    break;
                }
                temp = temp.next;
            }
            if(flag == 1) break;
            ListNode last = one;
            ListNode newEnd = two;
            for (int i = 0; two != null && i < k; i++) {
                two.next = one;
                one = two;
                two = three;
                if (three != null) three = three.next;
            }
            if (last != null) {
                last.next = one;
            } else {
                head = one;
            }
            newEnd.next = two;
            one = newEnd;
            
    }
         return head;
}
}