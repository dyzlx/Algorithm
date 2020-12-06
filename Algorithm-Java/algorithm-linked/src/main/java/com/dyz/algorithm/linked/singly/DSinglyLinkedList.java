package com.dyz.algorithm.linked.singly;

import java.util.Objects;

public class DSinglyLinkedList<T> {

    /*
    no data store in head node, it's only a mark of start
     */
    private SinglyLinkedNode<T> head;

    /*
    init head node with null value
     */
    public DSinglyLinkedList() {
        head = new SinglyLinkedNode<>(null);
    }

    public void addAtLast(T value) {
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(value);
        SinglyLinkedNode<T> current = this.head;
        while (Objects.nonNull(current.getNext())) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void addAtFirst(T value) {
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(value);
        SinglyLinkedNode<T> temp = this.head.getNext();
        this.head.setNext(newNode);
        newNode.setNext(temp);
    }

    public void addByIndex(T value, int index) {

    }

    public void removeAtLast() {

    }

    public void removeAtFirst() {

    }

    public int length() {
        int result = 0;
        SinglyLinkedNode<T> current = this.head;
        while (Objects.nonNull(current.getNext())) {
            result++;
            current = current.getNext();
        }
        return result;
    }

    public void print() {
        SinglyLinkedNode<T> current = this.head;
        while (Objects.nonNull(current.getNext())) {
            System.out.print(current.getNext().getValue() + ", ");
            current = current.getNext();
        }
        System.out.println();
    }
}
