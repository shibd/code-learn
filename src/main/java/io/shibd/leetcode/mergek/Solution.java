package io.shibd.leetcode.mergek;

/**
 * 23. 合并K个升序链表
 * @author baozi
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = (right + left) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head, list1Px = list1, list2Px = list2;
        while (list1Px != null && list2Px != null) {
            if (list1Px.val > list2Px.val) {
                tail.next = list2Px;
                list2Px = list2Px.next;
            } else {
                tail.next = list1Px;
                list1Px = list1Px.next;
            }
            tail = tail.next;
        }
        tail.next = (list1Px == null ? list2Px : list1Px);
        return head.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
