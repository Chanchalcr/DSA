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
    
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
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

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
    
    //this is bubble sort in linked  list
//     public ListNode sortList(ListNode head) {
//         int n= 0;
//         ListNode t = head;
//         while(t != null) {
//             n+= 1;
//             t = t.next;
//         }
//         if(n<= 1) return head;
        
//         for(int i=0; i< n-1; i++) {
//             ListNode p = head;
//             for(int j=0; j< n-i-1; j++) {
//                 if(p.val > p.next.val){
//                     int temp = p.val;
//                     p.val = p.next.val;
//                     p.next.val = temp;
//                 }
//                 p = p.next;
//             }
//         }
//         return head;
//     }
}