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
//     public void reorderList(ListNode head) {
//         if(head == null || head.next == null || head.next.next == null) return;
        
//         ListNode t = midReverse(head);
//         ListNode t1 = head;
//         ListNode t2 = t;
//         while(t1 != null && t2 != null) {
//             ListNode temp = t1.next;
//             t1.next = t2;
//             t1 = temp;
            
//             temp = t2.next;
//             t2.next =t1;
//             t2 = temp;
//         } 
//     }
//     public ListNode midReverse(ListNode head) {
        
//         int size = sizeOfLL(head);
//         ListNode one = null;
//         ListNode two = head;
//         ListNode three = two.next;
        
//         for(int i=0; i< (size+1)/2; i++) {
//             one = two;
//             two = two.next;
//         }
        
//         ListNode last = one;
//         one = null;
//         while(two != null) {
//             two.next = one;
//             one = two;
//             two = three;
//             if(three != null) three = three.next;
//         }
//         return one;
//     }
//     public int sizeOfLL(ListNode head) {
//         int size = 0;
//         ListNode temp = head;
//         while(temp != null) {
//             temp = temp.next;
//             size++;
//         }
//         return size;
//     }
    public void reorderList(ListNode head) {
            if(head==null||head.next==null) return;
            
            //Find the middle of the list
            ListNode p1=head;
            ListNode p2=head;
            while(p2.next!=null&&p2.next.next!=null){ 
                p1=p1.next;
                p2=p2.next.next;
            }
            
            //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
            ListNode preMiddle=p1;
            ListNode preCurrent=p1.next;
            while(preCurrent.next!=null){
                ListNode current=preCurrent.next;
                preCurrent.next=current.next;
                current.next=preMiddle.next;
                preMiddle.next=current;
            }
            
            //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
            p1=head;
            p2=preMiddle.next;
            while(p1!=preMiddle){
                preMiddle.next=p2.next;
                p2.next=p1.next;
                p1.next=p2;
                p1=p2.next;
                p2=preMiddle.next;
            }
        }
}



















