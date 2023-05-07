import java.util.LinkedList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode(){

    }

    ListNode(int val , ListNode next){
        this.val = val;
        this.next = next;

    }

    public static ListNode FindingMiddleNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;

    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode current = head;
        ListNode prev = null;
        ListNode next = current.next;

        while (current != null){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }

        }
        return prev;
    }

    public void reorderList(ListNode head){
        /* checking base condition*/
        if(head == null || head.next == null){
            return;
        }

        ListNode MiddleNode = FindingMiddleNode(head);
        ListNode headSecondNode = reverseList(MiddleNode);
        ListNode headFirstNode = head;

        while (headFirstNode != null || headSecondNode != null){
            ListNode temp = headFirstNode.next;
            headFirstNode.next = headSecondNode;
            headFirstNode = temp;

            temp = headSecondNode.next;
            headSecondNode.next = headFirstNode;
            headSecondNode = temp;
        }

        if(headFirstNode != null){
            headFirstNode.next = null;
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);list.add(3);list.add(4);list.add(7);
        list.add(1);list.add(2);list.add(6);
        ListNode head = new ListNode();
    }




    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode();
        start.next = head;
        ListNode fastNode = start;
        ListNode slowNode = start;

        for(int i= 0 ;i<n;i++){
            fastNode = fastNode.next;
        }

        while(fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        slowNode.next = slowNode.next.next;

        return start.next;


    }

}
