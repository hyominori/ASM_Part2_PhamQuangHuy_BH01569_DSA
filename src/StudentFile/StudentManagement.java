package StudentFile;

public class StudentManagement {
    private StudentStack studentStack;

    public StudentManagement(){
        this.studentStack = new StudentStack();
    }

    public void addStudent (Student student){
        if (searchStudent(student.getId()) != null) {
            System.out.println("Error: Student with ID " + student.getId() + " already exists.");
            return;
        }
        studentStack.push(student);
        System.out.println("Added student: " + student);
    }

    public void updateStudent(int id, String newName, double newMark){
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()){
            Student currentStudent = studentStack.pop();
            if (currentStudent.getId() == id){
                tempStack.push(new Student(id, newName, newMark));
                found = true;
            } else{
                tempStack.push(currentStudent);
            }
        }

        while (!tempStack.isEmpty()){
            studentStack.push(tempStack.pop());
        }

        if (!found){
            System.out.println("Student with ID" + id + " not found");
        } else {
            System.out.println("Updated student with ID: " + id);
        }
    }

    public void deleteStudent(int id){
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()){
            Student currentStudent = studentStack.pop();
            if (currentStudent.getId() == id) {
                // If found, skip adding it back
                found = true;
            } else {
                tempStack.push(currentStudent);
            }
        }
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        } else {
            System.out.println("Deleted student with ID: " + id);
        }
    }

    public Student searchStudent(int id) {
        StudentStack tempStack = new StudentStack();
        Student foundStudent = null;

        // Search for the student in the stack
        while (!studentStack.isEmpty()) {
            Student currentStudent = studentStack.pop();
            if (currentStudent.getId() == id) {
                foundStudent = currentStudent;
            }
            tempStack.push(currentStudent);
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        return foundStudent;
    }

    public void sortStudentsByMarks() {
        StudentStack sortedStack = new StudentStack();

        while (!studentStack.isEmpty()) {
            Student currentStudent = studentStack.pop();
            // Insert the currentStudent into the sortedStack in the correct order
            while (!sortedStack.isEmpty() && sortedStack.peek().getMark() > currentStudent.getMark()) {
                studentStack.push(sortedStack.pop());
            }
            sortedStack.push(currentStudent);
        }

        // Restore the original stack with sorted elements
        while (!sortedStack.isEmpty()) {
            studentStack.push(sortedStack.pop());
        }

        System.out.println("Students sorted by marks.");
    }

    // Display all students
    public void displayStudents() {
        System.out.println("Displaying all students:");
        studentStack.displayStack();
    }
}