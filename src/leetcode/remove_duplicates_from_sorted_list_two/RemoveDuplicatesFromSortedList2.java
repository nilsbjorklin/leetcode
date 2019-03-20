package leetcode.remove_duplicates_from_sorted_list_two;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode start = null;
        ListNode startPos = null;
        boolean duplicate = false;
        while (head.next != null) {
            int curVal = head.next.val, lastVal = head.val;
            if (head.next.val != head.val) {
                if (duplicate) {
                    duplicate = false;
                } else {
                    if (start == null) {
                        start = head;
                        startPos = head;
                    } else {
                        startPos.next = head;
                        startPos = startPos.next;
                    }
                }
            } else {
                duplicate = true;
            }
            head = head.next;
        }
        if (startPos != null) {
            if (!duplicate)
                startPos.next = head;
            else
                startPos.next = null;
        } else if(!duplicate){
            start = head;
        }
        return start;
    }
}