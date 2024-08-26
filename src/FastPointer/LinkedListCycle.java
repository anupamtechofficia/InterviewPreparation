package FastPointer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListCycle {

    static public class LinkListNode{
        int value;
        LinkListNode next;

        LinkListNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    public static boolean findLinkedListCycle(LinkListNode head){
        if(head == null || head.next == null) return false;
        LinkListNode slow = head;
        LinkListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
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
        System.out.println(findLinkedListCycle(makeList(arr)));
        int[] ar1 = {1, 1};
        System.out.println(findLinkedListCycle(makeList(ar1)));
        int[] arr2 = {1, 2, 3, 5 , 5, 6};
        System.out.println(findLinkedListCycle(makeList(arr2)));

    }

}
