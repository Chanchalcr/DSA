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
        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode temp = dummy;
        
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        temp = dummy;
        while(temp.next!=null){
            if(count<k) break;
            int nodes = k-1;
            ListNode tempnext = temp.next;
            ListNode first = temp.next;
            ListNode second = first.next;
            
            while(nodes-- > 0){
                ListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }
            count-=k;
            temp.next = first;
            tempnext.next = second;
            temp = tempnext;
            
        }
        return dummy.next;
//          if(k==1 || head == null) return head;
//         ListNode one = null;
//         ListNode two = head;
//         ListNode three = head.next;
//         while(true) {
//             int flag = 0;
//             ListNode temp = two;
//             for (int i = 0; i < k; i++) {
//                 if (temp == null) {
//                     flag = 1;
//                     break;
//                 }
//                 temp = temp.next;
//             }
//             if(flag == 1) break;
//             ListNode last = one;
//             ListNode newEnd = two;
//             for (int i = 0; two != null && i < k; i++) {
//                 two.next = one;
//                 one = two;
//                 two = three;
//                 if (three != null) three = three.next;
//             }
//             if (last != null) {
//                 last.next = one;
//             } else {
//                 head = one;
//             }
//             newEnd.next = two;
//             one = newEnd;
            
//     }
//          return head;
}
}