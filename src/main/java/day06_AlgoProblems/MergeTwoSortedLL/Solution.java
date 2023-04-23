package day06_AlgoProblems.MergeTwoSortedLL;

public class Solution {
    public ListNode mergeTwoLists(ListNode curr1, ListNode curr2) {
    // create a dummy head Node:
        ListNode tempHead = new ListNode();
        ListNode prev = tempHead;

        while (curr1 != null && curr2 != null) {

            if (curr1.val <= curr2.val) {       // linking in SORTED order
    // if curr1.val is smaller/equal use prev to link to list 1
                prev.next = curr1;
                curr1 = curr1.next;
            } else {
    // if curr1.val is larger use prev to link to list 2
                prev.next = curr2;
                curr2 = curr2.next;
            }
            prev = prev.next;
        }
    // check if there are any leftover nodes:
        if (curr1 == null) {
            prev.next = curr2;
        } else {
            prev.next = curr1;
        }
        return tempHead.next;   // return head of merged list using tempHead link
    }
}