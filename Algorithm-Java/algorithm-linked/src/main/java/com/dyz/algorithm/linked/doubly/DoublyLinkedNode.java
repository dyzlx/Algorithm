package com.dyz.algorithm.linked.doubly;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoublyLinkedNode<T> {
    private T value;
    private DoublyLinkedNode<T> pre;
    private DoublyLinkedNode<T> next;
}
