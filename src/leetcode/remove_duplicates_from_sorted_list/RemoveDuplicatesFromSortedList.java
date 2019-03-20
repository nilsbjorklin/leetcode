package leetcode.remove_duplicates_from_sorted_list;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode start = null;
        ListNode startPos = null;
        while (head != null) {
            if (head.next == null || head.next.val != head.val) {
                    if (start == null) {
                        start = head;
                        startPos = head;
                    } else {
                        startPos.next = head;
                        startPos = startPos.next;
                    }
            } 
            head = head.next;
        }
        return start;
    }
}