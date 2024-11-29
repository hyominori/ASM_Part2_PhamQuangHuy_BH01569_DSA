package Queue;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListQueue {
    private Node front;
    private Node rear;
    private int size;

    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Enqueue
    public void enqueue(int element) {
        Node newNode = new Node(element);
        if (rear == null) { // If queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode; // Link new node at the end
            rear = newNode;
        }
        size++;
    }

    // Dequeue
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = front.data;
        front = front.next; // Move front to the next node
        if (front == null) { // If queue becomes empty
            rear = null;
        }
        size--;
        return element;
    }

    // Peek
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    // Size
    public int size() {
        return size;
    }
}
