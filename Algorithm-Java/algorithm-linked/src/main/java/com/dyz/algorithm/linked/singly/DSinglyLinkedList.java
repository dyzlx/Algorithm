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

    /*
    index location is [current.next], and it should insert between [current] and [current.next]
    [current] is the pre actually

    you can only check out of rang by define a global var length, and check if index is larger than length
    but you mast ensure the var length is thread-safe
     */
    public void addByIndex(T value, int index) throws Exception {
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(value);
        SinglyLinkedNode<T> current = this.head;
        int currentIndex = 0;
        while(Objects.nonNull(current.getNext())) {
            if(currentIndex == index) {
                SinglyLinkedNode<T> temp = current.getNext();
                current.setNext(newNode);
                newNode.setNext(temp);
                return;
            }
            currentIndex++;
            current = current.getNext();
        }
        throw new Exception("index "+index+" out of range "+currentIndex);
    }

    public T removeAtLast() {
        return null;
    }

    public T removeAtFirst() {
        return null;
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
