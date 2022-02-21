package com.dyz.algorithm.leetcode;

import java.util.Objects;

/**
 *
 * delete duplicate element in a linked list
 *
 */
public class DeleteDuplicateElementInLinkedList {

    public static void main(String[] args) {

        Node head =new  Node(1);
        Node n1 =new  Node(1);
        Node n2 =new  Node(2);
        Node n3 =new  Node(2);
        Node n4 =new  Node(5);
        Node n5 =new  Node(5);
        head.next = n1;n1.next = n2;n2.next=n3;n3.next=n4;n4.next=n5;
        //print(head);
        print(fun(head));
    }

    private static Node fun(Node head) {
        if(Objects.isNull(head)) {
            return null;
        }
        Node result = new Node(-1);
        result.next = head;
        Node current = result;
        // 遍历
        while(Objects.nonNull(current.next) && Objects.nonNull(current.next.next)) {
            if(current.next.value == current.next.next.value) {
                Node temp = current.next;
                while (Objects.nonNull(temp.next) && temp.value == temp.next.value) {
                    temp = temp.next;
                }
                current.next = temp; //
            } else {
                current = current.next;
            }
        }
        return result.next;
    }

    private static void print(Node head) {
        Node node = head;
        while(Objects.nonNull(node)) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    static class Node {
        private int value;
        private Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        public Node(int value) {
            this.value = value;
        }
        public Node() {}
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
}
