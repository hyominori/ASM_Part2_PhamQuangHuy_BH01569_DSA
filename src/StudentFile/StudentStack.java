package StudentFile;

public class StudentStack {

    private Node top;

    public StudentStack(){
        this.top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(Student student){
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    public Student pop(){
        if(isEmpty()){
            System.out.println("Stack is empty. No students to remove.");
            return null;
        }
        Student removedStudent = top.student;
        top = top.next;
        return removedStudent;
    }

    public Student peek(){
        if (isEmpty()){
            System.out.println("Stack is empty. No students to show");
            return null;
        }
        return top.student;
    }

    public void displayStack(){
        if (isEmpty()){
            System.out.println("No students in the stack.");
            return;
        }
        Node current = top;
        while (current != null){
            System.out.println(current.student);
            current = current.next;
        }
    }
}
