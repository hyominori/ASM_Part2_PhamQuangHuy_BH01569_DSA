//package StudentFile;
//
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        StudentManagement management = new StudentManagement();
//        Scanner scanner = new Scanner(System.in);
//
//        // Thêm sinh viên ban đầu
//        management.addStudent(new Student(1, "Huy", 10));
//        management.addStudent(new Student(2, "Quang", 9));
//        management.addStudent(new Student(3, "Tuan", 5));
//        management.addStudent(new Student(4, "Chi", 6));
//        management.addStudent(new Student(5, "Vu", 6));
//        management.addStudent(new Student(6, "Hoang", 9));
//        management.addStudent(new Student(7, "Han", 9));
//        management.addStudent(new Student(8, "Tu", 10));
//
//        while (true) {
//            System.out.println("\n ---Student Management System--- ");
//            System.out.println("1. Add Student");
//            System.out.println("2. Update Student");
//            System.out.println("3. Delete Student");
//            System.out.println("4. Search Student");
//            System.out.println("5. Sort Student by Marks");
//            System.out.println("6. Display all Students");
//            System.out.println("7. Exit");
//            System.out.println("Choose your option: ");
//
//            try {
//                int choice = scanner.nextInt();
//                scanner.nextLine(); // Clear buffer
//
//                switch (choice) {
//                    case 1:
//                        try {
//                            System.out.print("Enter Student ID: ");
//                            int id = scanner.nextInt();
//                            scanner.nextLine(); // Clear buffer
//
//                            System.out.print("Enter Student Name: ");
//                            String name = scanner.nextLine();
//                            if (!name.matches("[a-zA-Z\\s]+")) { // Validate name
//                                if (name.matches("")) {
//                                    throw new IllegalArgumentException("Invalid name! Name can't be blank.");
//                                }
//                                throw new IllegalArgumentException("Invalid name! Only letters and spaces are allowed.");
//                            }
//
//                            System.out.print("Enter Student Marks: ");
//                            double marks = scanner.nextDouble();
//                            if (marks < 0 || marks > 10) { // Validate marks
//                                throw new IllegalArgumentException("Invalid marks! Enter a value between 0 and 10.");
//                            }
//
//                            management.addStudent(new Student(id, name, marks));
//                        } catch (IllegalArgumentException e) {
//                            System.out.println("Error: " + e.getMessage());
//                        }
//                        break;
//
//                    case 2:
//                        try {
//                            System.out.print("Enter Student ID to update: ");
//                            int updateId = scanner.nextInt();
//                            scanner.nextLine(); // Clear buffer
//
//                            System.out.print("Enter new Student Name: ");
//                            String newName = scanner.nextLine();
//                            if (!newName.matches("[a-zA-Z\\s]+")) { // Validate name
//                                throw new IllegalArgumentException("Invalid name! Only letters and spaces are allowed.");
//                            }
//
//                            System.out.print("Enter new Student Marks: ");
//                            double newMark = scanner.nextDouble();
//                            if (newMark < 0 || newMark > 10) { // Validate marks
//                                throw new IllegalArgumentException("Invalid marks! Enter a value between 0 and 10.");
//                            }
//
//                            management.updateStudent(updateId, newName, newMark);
//                        } catch (IllegalArgumentException e) {
//                            System.out.println("Error: " + e.getMessage());
//                        }
//                        break;
//
//                    case 3:
//                        try {
//                            System.out.print("Enter Student ID to delete: ");
//                            int deleteId = scanner.nextInt();
//                            management.deleteStudent(deleteId);
//                        } catch (Exception e) {
//                            System.out.println("Error: " + e.getMessage());
//                        }
//                        break;
//
//                    case 4:
//                        try {
//                            System.out.print("Enter Student ID to search: ");
//                            int searchId = scanner.nextInt();
//                            Student student = management.searchStudent(searchId);
//                            if (student != null) {
//                                System.out.println("Student Found: " + student);
//                            } else {
//                                System.out.println("Student with ID " + searchId + " not found.");
//                            }
//                        } catch (Exception e) {
//                            System.out.println("Error: " + e.getMessage());
//                        }
//                        break;
//
//                    case 5:
//                        management.sortStudentsByMarks();
//                        break;
//
//                    case 6:
//                        management.displayStudents();
//                        break;
//
//                    case 7:
//                        System.out.println("Exiting the system.");
//                        scanner.close();
//                        System.exit(0);
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            } catch (Exception e) {
//                System.out.println("Error: Invalid input. Please enter a number corresponding to the menu options.");
//                scanner.nextLine(); // Clear buffer
//            }
//        }
//    }
//}

package StudentFile;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Mảng tên để tạo ngẫu nhiên
        String[] names = {
                "Huy", "Quang", "Tuan", "Chi", "Vu", "Hoang",
                "Han", "Tu", "Mai", "Lan", "Minh", "Anh",
                "Trang", "Linh", "Duc", "Khoa", "Ngoc", "Hung"
        };

        // Nhập số lượng sinh viên ban đầu
        System.out.print("Nhập số lượng sinh viên ban đầu: ");
        try {
            int initialStudentCount = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            if (initialStudentCount <= 0) {
                throw new IllegalArgumentException("Số lượng sinh viên phải lớn hơn 0");
            }

            // Tạo danh sách sinh viên ban đầu
            for (int i = 1; i <= initialStudentCount; i++) {
                // Chọn tên ngẫu nhiên
                String randomName = names[random.nextInt(names.length)];

                // Tạo điểm số ngẫu nhiên từ 0 đến 10
                double randomMarks = Math.round(random.nextDouble() * 10 * 10.0) / 10.0;

                // Thêm sinh viên với ID tăng dần và tên, điểm số ngẫu nhiên
                management.addStudent(new Student(i, randomName, randomMarks));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
            return;
        }

        while (true) {
            System.out.println("\n ---Student Management System--- ");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Student by Marks");
            System.out.println("6. Sort Student by Marks (Using Bubble Sort)");
            System.out.println("7. Sort Student by Marks (Using Quick Sort)");
            System.out.println("8. Display all Students");
            System.out.println("9. Exit");
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
                                if (name.matches("")) {
                                    throw new IllegalArgumentException("Invalid name! Name can't be blank.");
                                }
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

                    // Các phần code còn lại giữ nguyên như ban đầu
                    case 2:
                        try {
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
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            System.out.print("Enter Student ID to delete: ");
                            int deleteId = scanner.nextInt();
                            management.deleteStudent(deleteId);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            System.out.print("Enter Student ID to search: ");
                            int searchId = scanner.nextInt();
                            Student student = management.searchStudent(searchId);
                            if (student != null) {
                                System.out.println("Student Found: " + student);
                            } else {
                                System.out.println("Student with ID " + searchId + " not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 5:
                        management.sortStudentsByMarks();
                        break;

                    case 6:
                        management.bubbleSortStudentsByMarks();
                        break;

                    case 7:
                        management.quickSortStudentsByMarks();
                        break;


                    case 8:
                        management.displayStudents();
                        break;

                    case 9:
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
        }
    }
}