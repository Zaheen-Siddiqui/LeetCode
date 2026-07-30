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
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode end = head;
        
        Stack<Integer> stack = new Stack<>();
        while(end != null){
            stack.push(end.val);
            end = end.next;
        }
        while(head != null){
            int top = stack.pop();
            if(top != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
