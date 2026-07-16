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
        if(head == null || head.next == null)
            return head;
        
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

if (k == 0)
            return head;
        ListNode travel = head;
        for(int i = 1; i <= k; i++){
            ListNode first = travel;
            while(travel.next.next != null){
                travel = travel.next;
            }
            travel.next.next = first;
            first = travel.next;
            travel.next = null;
            travel = first;
        }

        return travel;
    }
}
