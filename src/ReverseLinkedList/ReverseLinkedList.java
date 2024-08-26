package ReverseLinkedList;

import FastPointer.LinkedListCycle;
import FastPointer.StartOfLinkedListCycle;

import java.util.HashMap;
import java.util.Map;

public class ReverseLinkedList {

    static public class LinkListNode{
        int value;
        LinkListNode next;

        LinkListNode(int value){
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "LinkListNode{" +
                    "value=" + value +
                    '}';
        }
    }

    public static LinkListNode reserve(LinkListNode head){
        LinkListNode temp = head;
        LinkListNode prev = null;
        LinkListNode next = null;
        while (temp!=null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static LinkListNode reserveEveryKElement(LinkListNode head, int k){
        boolean first = true;
        LinkListNode temp= head;
        LinkListNode newHead = null;
        LinkListNode prevLastNode = null;
        while (temp!=null){
            LinkListNode kReverseNode = reverseK(temp , k);
            if(first){
                newHead = kReverseNode;
            } else {
                prevLastNode.next = kReverseNode;
            }
            first = false;
            prevLastNode = temp;
            temp = temp.next;
        }
        return newHead;
    }

    public static LinkListNode reserveEveryKAlternateElement(LinkListNode head, int k){
        boolean first = true;
        LinkListNode temp= head;
        LinkListNode newHead = null;
        LinkListNode prevLastNode = null;
        boolean reverse = true;
        while (temp!=null){
            if(reverse){
                LinkListNode kReverseNode = reverseK(temp , k);
                if(first){
                    newHead = kReverseNode;
                } else {
                    prevLastNode.next = kReverseNode;
                }
                first = false;
                prevLastNode = temp;
                temp = temp.next;
                reverse = false;
            } else {
                int nodes = 0;
                while (temp!=null && (nodes+1)< k){
                    temp  = temp.next;
                    nodes++;
                }
                prevLastNode = temp;
                temp = temp.next;
                reverse = true;
            }

        }
        return newHead;
    }

    public static LinkListNode reverseK(LinkListNode head, Integer k){
        LinkListNode temp= head;
        LinkListNode prev = null;
        LinkListNode next = null;
        int nodes = 0;
        while (temp!=null && nodes<k){
           next = temp.next;
           temp.next = prev;
           prev = temp;
           temp = next;
            nodes++;
        }
        head.next = next;
        return prev;

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

    public static void print(LinkListNode head){
        LinkListNode temp = head;
        while (temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }




    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        print(reserveEveryKAlternateElement(makeList(arr), 2));

    }


}
