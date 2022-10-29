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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
         return recursion(null,head,head.next);
    }
    public ListNode recursion(ListNode i, ListNode j, ListNode k) {
        j.next = i;
        if(k == null) return j;
        return recursion(j,k,k.next);
    }
}