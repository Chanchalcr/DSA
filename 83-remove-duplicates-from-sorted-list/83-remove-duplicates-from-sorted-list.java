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
    public ListNode deleteDuplicates(ListNode head) {
        
        //in this approach I have used a hashSet so this method will work even if the list is not               sorted
        
//         if(head == null || head.next == null) {
//             return head;
//         }
        
//         HashSet<Integer> set = new HashSet<>();
//         set.add(head.val);
//         ListNode temp = head;
//         while(temp.next != null) {
//             if(set.add(temp.next.val)) {
//                 temp = temp.next;
//             }else {
//                 temp.next = temp.next.next;
//             }
//         }
//         return head;
        
        if(head == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = head.next;
        while(two != null) {
            if(two.val == one.val) {
                two = two.next;
            }else{
                one.next = two;
                one = two;
                two = two.next;
            }
        }
        one.next = null;
        return head;
    }
}