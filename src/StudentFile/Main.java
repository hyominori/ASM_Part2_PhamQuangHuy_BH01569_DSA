package StudentFile;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StudentStack stack  = new StudentStack();
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        management.addStudent(new Student(1, "Huy", 10));
        management.addStudent(new Student(2, "Quang", 9));
        management.addStudent(new Student(3, "Tuan", 5));
        management.addStudent(new Student(4, "Chi", 6));
        management.addStudent(new Student(5, "Vu", 6));
        management.addStudent(new Student(6, "Hoang", 9));
        management.addStudent(new Student(7, "Han", 9));
        management.addStudent(new Student(8, "Tu", 10));

        while (true) {
            System.out.println("\n ---Student Management System--- ");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Student by Marks");
            System.out.println("6. Display all Students");
            System.out.println("7. Exit");
            System.out.println("Choose your option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter Student ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Clear buffer

                            System.out.print("Enter Student Name: ");
                            String name = scanner.nextLine();
                            if (!name.matches("[a-zA-Z\\s]+")) { // Validate name
                                throw new IllegalArgumentException("Invalid name! Only letters and spaces are allowed.");
                            }

                            System.out.print("Enter Student Marks: ");
                            double marks = scanner.nextDouble();
                            if (marks < 0 || marks > 10) { // Validate marks
                                    throw new IllegalArgumentException("Invalid marks! Enter a value between 0 and 10.");
                            }

                            management.addStudent(new Student(id, name, marks));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            if (stack.isEmpty()) {
                                throw new IllegalStateException("The stack is empty. No students to update.");
                            }

                            System.out.print("Enter Student ID to update: ");
                            int updateId = scanner.nextInt();
                            scanner.nextLine(); // Clear buffer

                            System.out.print("Enter new Student Name: ");
                            String newName = scanner.nextLine();
                            if (!newName.matches("[a-zA-Z\\s]+")) { // Validate name
                                throw new IllegalArgumentException("Invalid name! Only letters and spaces are allowed.");
                            }

                            System.out.print("Enter new Student Marks: ");
                            double newMark = scanner.nextDouble();
                            if (newMark < 0 || newMark > 10) { // Validate marks
                                throw new IllegalArgumentException("Invalid marks! Enter a value between 0 and 10.");
                            }

                            management.updateStudent(updateId, newName, newMark);
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            if (stack.isEmpty()) {
                                throw new IllegalStateException("The stack is empty. No students to delete.");
                            }

                            System.out.print("Enter Student ID to delete: ");
                            int deleteId = scanner.nextInt();
                            management.deleteStudent(deleteId);
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            if (stack.isEmpty()) {
                                throw new IllegalStateException("The stack is empty. No students to search.");
                            }

                            System.out.print("Enter Student ID to search: ");
                            int searchId = scanner.nextInt();
                            Student student = management.searchStudent(searchId);
                            if (student != null) {
                                System.out.println("Student Found: " + student);
                            } else {
                                System.out.println("Student with ID " + searchId + " not found.");
                            }
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 5:
                        if (stack.isEmpty()) {
                            System.out.println("The stack is empty. No students to sort.");
                        } else {
                            management.sortStudentsByMarks();
                        }
                        break;

                    case 6:
                        if (stack.isEmpty()) {
                            System.out.println("The stack is empty. No students to display.");
                        } else {
                            management.displayStudents();
                        }
                        break;

                    case 7:
                        System.out.println("Exiting the system.");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a number corresponding to the menu options.");
                scanner.nextLine(); // Clear buffer
            }
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.println("Enter Student ID: ");
//                    int id = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter Student Name: ");
//                    String name = scanner.nextLine();
//                    System.out.print("Enter Student Marks: ");
//                    double marks = scanner.nextDouble();
//                    management.addStudent(new Student(id, name, marks));
//                    break;
//
//                case 2:
//                    System.out.println("Enter Student ID to update: ");
//                    int updateId = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.println("Enter new Student Name: ");
//                    String newName = scanner.nextLine();
//                    System.out.println("Enter new Student Mark: ");
//                    double newMark = scanner.nextDouble();
//                    management.updateStudent(updateId, newName, newMark);
//                    break;
//
//                case 3:
//                    System.out.print("Enter Student ID to delete: ");
//                    int deleteId = scanner.nextInt();
//                    management.deleteStudent(deleteId);
//                    break;
//
//                case 4:
//                    System.out.print("Enter Student ID to search: ");
//                    int searchId = scanner.nextInt();
//                    Student student = management.searchStudent(searchId);
//                    if (student != null) {
//                        System.out.println("Student Found: " + student);
//                    } else {
//                        System.out.println("Student with ID " + searchId + " not found.");
//                    }
//                    break;
//
//                case 5:
//                    management.sortStudentsByMarks();
//                    management.displayStudents();
//                    break;
//
//                case 6:
//                    // Display all students
//                    management.displayStudents();
//                    break;
//
//                case 7:
//                    // Exit the program
//                    System.out.println("Exiting the system.");
//                    scanner.close();
//                    System.exit(0);
//                    break;
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
        }
    }
}