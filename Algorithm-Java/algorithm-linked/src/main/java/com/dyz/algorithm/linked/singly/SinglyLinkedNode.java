package com.dyz.algorithm.linked.singly;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SinglyLinkedNode<T> {
    private T value;
    private SinglyLinkedNode<T> next;

    public SinglyLinkedNode(T value) {
        this.value = value;
    }
}
