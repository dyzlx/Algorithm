package com.dyz.algorithm.linked.singly;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SinglyNode<T> {

    private T value;

    private SinglyNode<T> next;

    public SinglyNode(T value) {
        this.value = value;
    }
}
