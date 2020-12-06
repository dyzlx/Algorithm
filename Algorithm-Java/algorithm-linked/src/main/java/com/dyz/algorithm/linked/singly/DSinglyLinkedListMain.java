package com.dyz.algorithm.linked.singly;

public class DSinglyLinkedListMain {

    public static void main(String[] args) {
        DSinglyLinkedList<String> myLinkedList = new DSinglyLinkedList<>();
        myLinkedList.addAtLast("ele1");
        myLinkedList.addAtLast("ele2");
        myLinkedList.addAtFirst("ele0");
        myLinkedList.addAtFirst("ele00");
        System.out.println(myLinkedList.length());
        myLinkedList.print();
    }
}
