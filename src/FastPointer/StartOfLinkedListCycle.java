package FastPointer;

import java.util.HashMap;
import java.util.Map;

public class StartOfLinkedListCycle {


    static public class LinkListNode{
        int value;
        LinkListNode next;

        LinkListNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    public static Integer findStartOfLinkedListCycle(LinkListNode head){
        LinkListNode meetingPoint = findMeetingPoint(head);
        if(meetingPoint == null){
            return null;
        }
        LinkListNode slow = head;
        LinkListNode fast = meetingPoint;

        while (fast!=slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast.value;
    }

    public static LinkListNode findMeetingPoint(LinkListNode head){
        if(head == null || head.next == null) return null;
        LinkListNode slow = head;
        LinkListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return slow;
        }
        return null;
    }

    public static LinkListNode makeList(int[] arr){
        LinkListNode head = null;
        LinkListNode temp = head;
        Map<Integer, LinkListNode> map = new HashMap<>();
        for(int i = 0;i< arr.length;i++){
            if(head == null){
                head = new LinkListNode(arr[0]);
                temp = head;
                map.put(arr[0], temp);
                continue;
            }

            temp.next = map.getOrDefault(arr[i], new LinkListNode(arr[i]));
            temp = temp.next;
            map.put(arr[i], temp);
        }
        return head;
    }



    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5 , 5, 6, 3};
        System.out.println(findStartOfLinkedListCycle(makeList(arr)));
        int[] ar1 = {1, 1};
        System.out.println(""+ findStartOfLinkedListCycle(makeList(ar1)));
        int[] arr2 = {1, 2, 3, 5 , 5, 6};
        System.out.println("" + findStartOfLinkedListCycle(makeList(arr2)));

    }
}
