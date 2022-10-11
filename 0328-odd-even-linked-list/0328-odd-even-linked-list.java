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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode newHead = new ListNode(head.val);
        ListNode newTail = newHead;
        ListNode temp = head;
        
        while(temp != null && temp.next != null && temp.next.next != null) {
            temp = temp.next.next;
            ListNode t = new ListNode(temp.val);
            newTail.next = t;
            newTail = newTail.next;
        }
        temp = head.next;
        newTail.next = new ListNode(temp.val);
        newTail = newTail.next;
        while(temp != null && temp.next != null && temp.next.next != null) {
            temp = temp.next.next;
            ListNode t = new ListNode(temp.val);
            newTail.next = t;
            newTail = newTail.next;
        }
        return newHead;
    }
}