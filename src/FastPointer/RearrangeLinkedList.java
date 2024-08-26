package FastPointer;

public class RearrangeLinkedList {

    static public class LinkListNode{
        int value;
        LinkListNode next;

        LinkListNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    public static void rearrangeLinkedList(LinkListNode head){
        LinkListNode mid = getMidPoint(head);
        LinkListNode secondHalf = reverse(mid);
        LinkListNode headFinal = head;
        while (head!=null && secondHalf!=null){
            LinkListNode headNext = head.next;
            LinkListNode secondHalfNext = secondHalf.next;
            head.next = secondHalf;
            if(headNext!=null){
                secondHalf.next = headNext;
            }
            head = headNext;
            secondHalf = secondHalfNext;
        }
        if(secondHalf!=null){

        }
        LinkListNode temp = headFinal;
        while (temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }



    public static LinkListNode getMidPoint(LinkListNode head){
        if(head == null) return null;
        LinkListNode slow = head;
        LinkListNode fast = head;
        LinkListNode prev = null;
        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    public static LinkListNode reverse(LinkListNode head){
        LinkListNode current = head;
        LinkListNode prev = null;
        LinkListNode next = head.next;
        while (next!=null){
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        return current;
    }


    public static LinkListNode makeList(int[] arr){
        LinkListNode head = null;
        LinkListNode temp = head;
        for(int i = 0;i< arr.length;i++){
            if(head == null){
                head = new LinkListNode(arr[0]);
                temp = head;
                continue;
            }

            temp.next =  new LinkListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }



    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8 ,10 , 12};
        rearrangeLinkedList(makeList(arr));
        System.out.println("\n");
        int[] arr1 = {2, 4,   6, 8 ,10 };
        rearrangeLinkedList(makeList(arr1));

    }
}
