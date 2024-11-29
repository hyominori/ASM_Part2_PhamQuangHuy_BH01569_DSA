package DataStructure;

import java.util.EmptyStackException;

public class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Push
    public void push(int element) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        arr[++top] = element;
    }

    // Pop
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    // Peek
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    // isEmpty
    public boolean isEmpty() {
        return top == -1;
    }
}

