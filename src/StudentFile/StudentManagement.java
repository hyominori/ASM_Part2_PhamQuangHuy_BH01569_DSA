package StudentFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
public class StudentManagement {


    private StudentStack studentStack;

    public StudentManagement(){
        this.studentStack = new StudentStack();
    }

    public void addStudent (Student student){
        // Kiểm tra xem sinh viên đã tồn tại chưa
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
                currentStudent.setName(newName);
                currentStudent.setMark(newMark);
                tempStack.push(currentStudent);
                found = true;
            } else{
                tempStack.push(currentStudent);
            }
        }

        // Khôi phục lại stack ban đầu
        while (!tempStack.isEmpty()){
            studentStack.push(tempStack.pop());
        }

        if (!found){
            System.out.println("Student with ID " + id + " not found");
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
                // Nếu tìm thấy, bỏ qua sinh viên này
                found = true;
            } else {
                tempStack.push(currentStudent);
            }
        }
        // Khôi phục lại stack ban đầu
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

        // Tìm kiếm sinh viên trong stack
        while (!studentStack.isEmpty()) {
            Student currentStudent = studentStack.pop();
            if (currentStudent.getId() == id) {
                foundStudent = currentStudent;
            }
            tempStack.push(currentStudent);
        }

        // Khôi phục lại stack ban đầu
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        return foundStudent;
    }

    public void quickSortStudentsByMarks() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBeforeSort = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();
        // Chuyển stack sang mảng để thực hiện quicksort
        ArrayList<Student> studentList = new ArrayList<>();
        while (!studentStack.isEmpty()) {
            studentList.add(studentStack.pop());
        }

        // Gọi phương thức quicksort
        quickSort(studentList, 0, studentList.size() - 1);

        // Đưa các sinh viên đã sắp xếp trở lại stack
        for (int i = studentList.size() - 1; i >= 0; i--) {
            studentStack.push(studentList.get(i));
        }

        long end = System.nanoTime();
        long memoryAfterSort = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Students sorted by marks using Quick Sort.");
        System.out.println("Run time Quick Sort:"+ (end - start) + " ns");
        System.out.println("Quick Sort Memory Usage: " + (memoryAfterSort-memoryBeforeSort) + " bytes");
    }

    private void quickSort(ArrayList<Student> arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(ArrayList<Student> arr, int low, int high) {
        double pivot = arr.get(high).getMark();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j).getMark() <= pivot) {
                i++;
                // Swap
                Student temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // Swap pivot
        Student temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    public void bubbleSortStudentsByMarks() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBeforeSort = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();
        // Chuyển stack sang mảng để thực hiện bubble sort
        ArrayList<Student> studentList = new ArrayList<>();
        while (!studentStack.isEmpty()) {
            studentList.add(studentStack.pop());
        }

        // Thực hiện bubble sort
        int n = studentList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (studentList.get(j).getMark() > studentList.get(j + 1).getMark()) {
                    // Swap
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
            }
        }

        // Đưa các sinh viên đã sắp xếp trở lại stack
        for (int i = studentList.size() - 1; i >= 0; i--) {
            studentStack.push(studentList.get(i));
        }
        long end = System.nanoTime();
        long memoryAfterSort = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Students sorted by marks using Bubble Sort.");
        System.out.println("Run time Bubble:"+ (end - start) + " ns");
        System.out.println("Bubble Sort Memory Usage: " + (memoryAfterSort-memoryBeforeSort) + " bytes");
    }

    public void sortStudentsByMarks() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBeforeSort = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();
        StudentStack sortedStack = new StudentStack();

        while (!studentStack.isEmpty()) {
            Student currentStudent = studentStack.pop();
            // Chèn currentStudent vào sortedStack theo thứ tự phù hợp
            while (!sortedStack.isEmpty() && sortedStack.peek().getMark() > currentStudent.getMark()) {
                studentStack.push(sortedStack.pop());
            }
            sortedStack.push(currentStudent);
        }

        // Khôi phục lại stack ban đầu với các phần tử đã sắp xếp
        while (!sortedStack.isEmpty()) {
            studentStack.push(sortedStack.pop());
        }
        long end = System.nanoTime();
        long memoryAfterSort = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Students sorted by marks.");
        System.out.println("Run time Sort:"+ (end - start) + " ns");
        System.out.println("Sort Memory Usage: " + (memoryAfterSort-memoryBeforeSort) + " bytes");
    }

    // Hiển thị tất cả sinh viên
    public void displayStudents() {
        System.out.println("Displaying all students:");
        studentStack.displayStack();
    }
}