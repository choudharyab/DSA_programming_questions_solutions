package LinkedList;

public class SwapNode {
    class ListNode {
        int val ;
        ListNode next;
    }
    public ListNode create(ListNode head, int x) {
        ListNode temp = new ListNode();
        ListNode ptr = head;
        temp.val = x;
        temp.next = null;
        if (head == null) {
            head = temp;
        }
        else {
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
        return head;
    }
    public void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode swapNodes(ListNode head , int k){
        int len = 0 ;
        ListNode temp = head;
        while (temp != null){
            len++;
            temp = temp.next;
        }

        if(len < k) return head;
        if(2*k -1 == len) return head;

        ListNode prev_left = null;
        ListNode left = head;

        for(int i=1;i<k;i++){
            prev_left = left;
            left = left.next;
        }

        ListNode prev_right = null;
        ListNode right = head;
        int remLen = len - k +1;

        for(int i=1;i<remLen;i++){
           prev_right = right;
           right = right.next;
        }

        if(prev_left != null){
            prev_left.next = right;
        }

        if(prev_right != null){
            prev_right.next = left;
        }

        ListNode swapTemp = left.next;
        left.next = right.next;
        right.next = swapTemp;

        if(k ==1) head = right;
        if(k == len)  head = left;

        return head;


    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return  head;

        ListNode prev = null;
        ListNode current = head;

        for(int i = 0 ;current != null && i< left-1;i++){
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;
        ListNode next = current.next;
        for(int i =0 ; current != null && i< right-left+1;i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else {
            head = prev;
        }

        newEnd.next = current;


        return  head;
    }


    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode temp = head;

        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) {

            /* Swap the data */
            int k = temp.val;
            temp.val = temp.next.val;
            temp.next.val = k;
            temp = temp.next.next;
        }

        return head;
    }


        public static void main(String[] args) {
        SwapNode l = new SwapNode();

            ListNode head = null;

        head = l.create(head, 1);
        head = l.create(head, 2);
        head = l.create(head, 3);
        head = l.create(head, 4);
//        head = l.create(head, 5);

        System.out.println(
                "Linked List before modification: ");
        l.display(head);

       // head = l.swapNodes(head,2);
      //  head = l.reverseBetween(head,2,4);
            head = l.swapPairs(head);
        System.out.println(
                "Linked List after modification: ");
        l.display(head);
    }
}
