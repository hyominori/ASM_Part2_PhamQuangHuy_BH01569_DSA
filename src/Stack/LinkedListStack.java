package Stack;

public class LinkedListStack {
    private Node top;  // Top node of the stack

    // Constructor to initialize the stack
    public LinkedListStack() {
        this.top = null;  // Stack is initially empty
    }

    // Push operation
    public void push(int value) {
        Node newNode = new Node(value);  // Create a new node
        newNode.next = top;  // New node points to current top
        top = newNode;  // Update top to the new node
    }

    // Pop operation
    public int pop() {
        if (top == null) {  // Stack underflow condition
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int value = top.value;  // Get the top element
            top = top.next;  // Update top to the next node
            return value;
        }
    }

    // Peek operation
    public int peek() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return top.value;  // Return the top element
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();  // Create an empty stack
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peek());  // Output: 20
        stack.pop();
        System.out.println(stack.peek());  // Output: 10
    }
}

class Node {
    int value;
    Node next;

    // Constructor to initialize a node
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

