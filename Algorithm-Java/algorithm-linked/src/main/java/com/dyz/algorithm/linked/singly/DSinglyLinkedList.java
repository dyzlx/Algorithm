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

    you can also check OutOfRangeException by define a global variable length, and check if index is larger than length
    but you mast ensure the variable length is thread-safe
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

    public void removeAtLast() {
        SinglyLinkedNode<T> current = this.head;
        while(Objects.nonNull(current.getNext())) {
            if(Objects.isNull(current.getNext().getNext())) {
                current.setNext(null);
                return;
            }
            current = current.getNext();
        }
    }

    public void removeAtFirst() {
        SinglyLinkedNode<T> current = this.head;
        if(Objects.isNull(current.getNext())) {
            return;
        }
        SinglyLinkedNode<T> deletedNext = current.getNext().getNext();
        current.getNext().setNext(null);
        current.setNext(deletedNext);
    }

    /*
    index location is current.next
     */
    public void removeByIndex(int index) throws Exception {
        if(index < 0) return;
        SinglyLinkedNode<T> current = this.head;
        int currentIndex = 0;
        while (Objects.nonNull(current.getNext())) {
            if(currentIndex == index) {
                SinglyLinkedNode<T> deletedNext = current.getNext().getNext();
                current.getNext().setNext(null);
                current.setNext(deletedNext);
                return;
            }
            currentIndex++;
            current = current.getNext();
        }
        throw new Exception("index "+index+" out of range "+currentIndex);
    }

    public void reverse() {

    }

    /*
    use extra space, like a stack
     */
    public void reverse2() {

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
        StringBuilder sb = new StringBuilder();
        SinglyLinkedNode<T> current = this.head;
        sb.append("[");
        while (Objects.nonNull(current.getNext())) {
            sb.append(current.getNext().getValue());
            if(Objects.nonNull(current.getNext().getNext())) {
                sb.append(",");
            }
            current = current.getNext();
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
