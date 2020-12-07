package com.dyz.algorithm.linked.singly;

public class DSinglyLinkedListMain {

    public static void main(String[] args) throws Exception {
        DSinglyLinkedList<String> myLinkedList = new DSinglyLinkedList<>();

        myLinkedList.addAtLast("ele1");
        myLinkedList.addAtLast("ele2");
        myLinkedList.addAtLast("ele3");

        System.out.println(myLinkedList.length());
        myLinkedList.print();

        myLinkedList.removeByIndex(1);
        System.out.println(myLinkedList.length());
        myLinkedList.print();

        myLinkedList.removeByIndex(1);
        System.out.println(myLinkedList.length());
        myLinkedList.print();

        myLinkedList.removeByIndex(0);
        System.out.println(myLinkedList.length());
        myLinkedList.print();

    }
}
