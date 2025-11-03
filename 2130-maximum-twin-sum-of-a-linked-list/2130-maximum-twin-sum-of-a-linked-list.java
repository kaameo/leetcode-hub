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
    public int pairSum(ListNode head) {
        // 1 3 4 5 6 2
        // 3, 9, 9
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.offerLast(head.val);
            head = head.next;
        }

        int n = deque.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, deque.pollFirst() + deque.pollLast());
        }
        return max;
    }
    // time complexity O(n)
    // space complexity O(n)
}