package edu.msmary.project2;

class LinkedStack {
    private static class Node {
        int data;
        Node  next;

        Node(int _data, Node _next) {
            data = _data;
            next = _next;
        }
    }
    private Node top;
    private int numElements;

    LinkedStack() {
        top = null;
        numElements = 0;
    }

    void push(int data) {
        top = new Node(data, top);
        numElements++;
    }


    int pop() {
        int element = top.data;
        top = top.next;
        numElements--;
        return element;
    }

    int look() {
        return top.data;
    }

    int get(int index) {
        Node ptr = top;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    int size() {
        return numElements;
    }
}
