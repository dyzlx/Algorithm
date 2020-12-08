package com.dyz.algorithm.linked.singly;

import java.util.Objects;
import java.util.Stack;

public class DSinglyLinkedList<T> {

    /*
    no data store in head node, it's only a mark of start
     */
    private SinglyNode<T> head;

    /*
    init head node with null value
     */
    public DSinglyLinkedList() {
        head = new SinglyNode<>(null);
    }

    /*
    public DSinglyLinkedList(SinglyNode<T> head) throws Exception {
        if(Objects.isNull(head)) {
            throw new Exception("head can't be null");
        }
        this.head = head;
    }*/

    public void addAtLast(T value) {
        SinglyNode<T> newNode = new SinglyNode<>(value);
        SinglyNode<T> current = this.head;
        while (Objects.nonNull(current.getNext())) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void addAtFirst(T value) {
        SinglyNode<T> newNode = new SinglyNode<>(value);
        SinglyNode<T> temp = this.head.getNext();
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
        SinglyNode<T> newNode = new SinglyNode<>(value);
        SinglyNode<T> current = this.head;
        int currentIndex = 0;
        while(Objects.nonNull(current.getNext())) {
            if(currentIndex == index) {
                SinglyNode<T> temp = current.getNext();
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
        SinglyNode<T> current = this.head;
        while(Objects.nonNull(current.getNext())) {
            if(Objects.isNull(current.getNext().getNext())) {
                current.setNext(null);
                return;
            }
            current = current.getNext();
        }
    }

    public void removeAtFirst() {
        SinglyNode<T> current = this.head;
        if(Objects.isNull(current.getNext())) {
            return;
        }
        SinglyNode<T> deletedNext = current.getNext().getNext();
        current.getNext().setNext(null);
        current.setNext(deletedNext);
    }

    /*
    index location is current.next
     */
    public void removeByIndex(int index) throws Exception {
        if(index < 0) return;
        SinglyNode<T> current = this.head;
        int currentIndex = 0;
        while (Objects.nonNull(current.getNext())) {
            if(currentIndex == index) {
                SinglyNode<T> deletedNext = current.getNext().getNext();
                current.getNext().setNext(null);
                current.setNext(deletedNext);
                return;
            }
            currentIndex++;
            current = current.getNext();
        }
        throw new Exception("index "+index+" out of range "+currentIndex);
    }

    /*
    three pointer: pre current next
    next = current.next
    current.next = pre
    pre = current
    current = next
     */
    public void reverse() {
        SinglyNode<T> pre = null;
        SinglyNode<T> current = this.head;
        SinglyNode<T> next;
        SinglyNode<T> first = this.head.getNext();
        while(Objects.nonNull(current)) {
            next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        // The head node points to the latest first node
        this.head.setNext(pre);
        // The old first ele next points to head, it'a loop.
        // so make first next point to null.
        if(Objects.nonNull(first)) {
            first.setNext(null);
        }
    }

    /*
    use extra space, like a stack
     */
    public void reverse_by_stack() {
        Stack<SinglyNode<T>> stack = new Stack<>();
        SinglyNode<T> current = this.head.getNext();
        while(Objects.nonNull(current)) {
            SinglyNode<T> next = current.getNext();
            SinglyNode<T> pushNode = current;
            pushNode.setNext(null);
            stack.push(pushNode);
            current = next;
        }
        SinglyNode<T> newCurrent = this.head;
        while (stack.size() !=0) {
            newCurrent.setNext(stack.pop());
            newCurrent = newCurrent.getNext();
        }
    }

    /*
    two pointer
    one pointer take one step at the time
    other pointer table two step at the time
    if the link has a loop, the two pointer will point to the same node.

    each loop check if fast pointer and it's next are null;
     */
    public boolean existLoop() {
        SinglyNode<T> p1 = this.head;
        SinglyNode<T> p2 = this.head.getNext();
        while (p1 != p2) {
            if(Objects.isNull(p2) || Objects.isNull(p2.getNext())) {
                return false;
            }
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
        }
        return true;
    }

    /*
    use equal() instead of ==
     */
    public boolean exist(T value) {
        SinglyNode<T> current = this.head;
        while (Objects.nonNull(current.getNext())) {
            if(current.getNext().getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int length() {
        int result = 0;
        SinglyNode<T> current = this.head;
        while (Objects.nonNull(current.getNext())) {
            result++;
            current = current.getNext();
        }
        return result;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        SinglyNode<T> current = this.head;
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
