package SortAlgo;


public class SortListMergeSort {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        return mergeSort(head);

    }

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        //find the middle node using fast and slow pointer
        ListNode l1 = getMiddle(head);
        ListNode l2 = l1.next;
        l1.next = null;
        //apply merge sort
        ListNode a = mergeSort(head);
        ListNode b = mergeSort(l2);

        return merge(a,b);

    }

    public ListNode merge (ListNode l1 , ListNode l2) {
        ListNode result = null;
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            result = l1;
            result.next = merge(l1.next,l2);

        }else {
            result = l2;
            result.next = merge(l1,l2.next);
        }

        return result;

    }

    public static ListNode getMiddle(ListNode head)
    {
        if (head == null)
            return head;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
