package DataStructure;

public class Queue {
    private int[] arr;
    private int front, rear, capacity, size;

    public Queue(int size) {
        arr = new int[size];
        this.capacity = size;
        front = 0;
        rear = -1;
        this.size = 0;
    }

    // Enqueue
    public void enqueue(int element) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = element;
        size++;
    }

    // Dequeue
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Peek
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return arr[front];
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }
}
