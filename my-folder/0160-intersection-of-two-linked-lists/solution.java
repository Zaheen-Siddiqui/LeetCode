/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 import java.util.Hashtable;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Hashtable<ListNode, Integer> ht = new Hashtable<>();
        ListNode HeadA = headA;
        ListNode HeadB = headB;
        
        while(HeadA != null){
            ht.put(HeadA, HeadA.val);
            HeadA = HeadA.next;
        }
        while(HeadB != null){
            if(ht.containsKey(HeadB)){
                return HeadB;
            }
            HeadB = HeadB.next;
        }
        return null;
    }
}
