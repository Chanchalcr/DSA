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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;
        
        ListNode temp = head;
        int size = 0;
        while(temp.next != null){
            temp = temp.next;
            size ++;
        }
        temp.next = head;
        size ++;
        k= k % size;
        ListNode one = head;
        ListNode two = head.next;
        for(int i=0; i< size-k-1; i++) {
            two = two.next;
            one = one.next;
        }
        one.next = null;
        head = two;
        return head;
    }
}