package leetcode.merge_two_sorted_lists;

public class MergeTwoSortedLists{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while(l1 != null || l2 != null){
            if (compareListNodes(l1, l2)) {
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }
        }
        return result.next;
    }
    boolean compareListNodes(ListNode l1, ListNode l2){
        if(l1 != null){
            if(l2 == null || l1.val <= l2.val)
                return true;
        }
        return false;
    }
}