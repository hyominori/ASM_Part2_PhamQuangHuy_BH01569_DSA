package Stack;

public class ArrayStack {
    private int[] stack;  // Array to store stack elements
    private int top;      // Top pointer
    private int capacity; // Maximum capacity of the stack

    // Constructor to initialize stack
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];  // Allocate memory for the stack
        top = -1;  // Initialize top to -1 (empty stack)
    }

    // Push operation
    public void push(int value) {
        if (top == capacity - 1) {  // Stack overflow condition
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;  // Increment top and insert element
        }
    }

    // Pop operation
    public int pop() {
        if (top == -1) {  // Stack underflow condition
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return stack[top--];  // Return top element and decrement top
        }
    }

    // Peek operation
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return stack[top];  // Return the top element
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);  // Create a stack of capacity 5
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peek());  // Output: 20
        stack.pop();
        System.out.println(stack.peek());  // Output: 10
     }
}
