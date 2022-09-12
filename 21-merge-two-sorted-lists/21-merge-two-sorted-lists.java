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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        
        while(list1 != null && list2 != null) {
            ListNode temp = new ListNode();
            if(list1.val <= list2.val) {
                temp.val = list1.val;
                list1 = list1.next;
            } else {
                temp.val = list2.val;
                list2 = list2.next;
            }
            tail.next = temp;
            tail = tail.next;
        }
        if(list1 != null) {
            tail.next = list1;
        }else {
            tail.next = list2;
        }
        return head.next;
    }
}