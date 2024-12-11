package leetcode.reverse_nodes_in_k_group;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        ListNode temp;
        ListNode currentNode = head;
        ListNode first = head;
        for (int i = 0; i < k; i++) {
            temp = currentNode.next;
            currentNode.next = result.next;
            result.next = currentNode;
            currentNode = temp;
        }
        first.next = currentNode;
        return result.next;
    }
}