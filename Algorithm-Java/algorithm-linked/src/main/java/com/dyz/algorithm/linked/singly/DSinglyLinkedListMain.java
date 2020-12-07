package com.dyz.algorithm.linked.singly;

public class DSinglyLinkedListMain {

    public static void main(String[] args) throws Exception {
        DSinglyLinkedList<String> myLinkedList = new DSinglyLinkedList<>();

        myLinkedList.addAtLast("ele1");
        myLinkedList.addAtLast("ele2");
        myLinkedList.addAtFirst("ele0");
        System.out.println(myLinkedList.length());
        myLinkedList.print();

        myLinkedList.addByIndex("ele-index-3", 2);
        System.out.println(myLinkedList.length());
        myLinkedList.print();

        myLinkedList.addByIndex("ele-index-1", 1);
        System.out.println(myLinkedList.length());
        myLinkedList.print();

        myLinkedList.addByIndex("ele-index-0", 0);
        System.out.println(myLinkedList.length());
        myLinkedList.print();
    }
}
