/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode traversal = head;
        
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                if(l2 != null) {
                    if(l1.val > l2.val) {
                        traversal.next = new ListNode(l2.val);
                        traversal = traversal.next;
                        l2 = l2.next;
                    } else {
                        traversal.next = new ListNode(l1.val);
                        traversal = traversal.next;
                        l1 = l1.next;
                    }
                } else {
                    traversal.next = l1;
                    break;
                }
            } else {
                traversal.next = l2;
                break;
            }
        }
        
        return head.next;
    }
}