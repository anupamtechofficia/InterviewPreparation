package cache;

import FastPointer.HappyNumber;

import java.util.HashMap;

public class LRU {

    class Node{
        int key;
        int value;

        Node prev;

        Node next;

        Node(int key, int value){
            this.value = value;
            this.prev = null;
            this.next = null;
            this.key = key;
        }

    }
    final int capacity;
    int currentCapacity;
    final HashMap<Integer, Node> map;

    Node head;

    Node last;

    LRU(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        last = null;
        currentCapacity = 0;
    }

    void  removeFromHead(){
        map.remove(head.key);
        head = head.next;
        currentCapacity--;
    }

    void  add(int key, int value){
        Node oldNode = map.get(key);
        if(oldNode !=null){
            oldNode.value = value;
            get(key);
            return;
        }
        Node newNode = new Node(key, value);
        if(head == null){
            head = newNode;
        } else {
            if(currentCapacity==capacity){
                removeFromHead();
            }
            if(currentCapacity!=0){
                last.next = newNode;
                newNode.prev = last;
            } else {
                head = newNode;
            }

        }
        last = newNode;
        currentCapacity++;
        map.put(key, newNode);
    }

    int  get(int x){
         Node node = map.get(x);
         if(node == null){
             return -1;
         }
         if(capacity == 1 || last == node){
             return node.value;
         }
        if(head == node){
            head = node.next;

        } else {
            node.prev.next = node.next;
            node.next.next = node.prev;
        }
        last.next = node;
        node.prev = last;
        node.next = null;
        last = node;
        return node.value;
    }

    public static void main(String ... s){
        LRU cache = new LRU(1);
        cache.add(15,11);
        cache.add(5,2);
        cache.add(1,15);
        cache.add(4,2);
        cache.get(5);

    }




}
