/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node newHead = new Node(0);
        Node temp = head;
        if(head == null) return head;
        //We are inserting new node in between the original linkedlist
        while(temp != null) {
            Node t = new Node(temp.val);
            Node right = temp.next;
            temp.next = t;
            t.next = right;
            temp = right;
        }
        
        temp = head;
        newHead = head.next;
        
        //we are using the original list to point the random pointers
        while(temp != null && temp.next != null) {
            if(temp.random == null) 
                temp.next.random = null;
            else {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        Node temp1 = newHead;
        temp = head;
        //the new list from the original one
        while(temp != null && temp.next != null && temp1 != null && temp1.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
            temp1.next = temp1.next.next;
            temp1 = temp1.next;         
        }  
        temp.next = null;
        return newHead;
    }    
}