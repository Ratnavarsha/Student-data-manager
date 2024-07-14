import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    static class Student {
        int id;
        String name;
        int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Age: " + age;
        }
    }

    static class StudentManager {
        private ArrayList<Student> students = new ArrayList<>();

        public void addStudent(int id, String name, int age) {
            students.add(new Student(id, name, age));
            System.out.println("Student added successfully!");
        }

        public void viewStudents() {
            if (students.isEmpty()) {
                System.out.println("No students to display.");
            } else {
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        }

        public void updateStudent(int id, String name, int age) {
            for (Student student : students) {
                if (student.id == id) {
                    student.name = name;
                    student.age = age;
                    System.out.println("Student updated successfully!");
                    return;
                }
            }
            System.out.println("Student not found.");
        }

        public void deleteStudent(int id) {
            students.removeIf(student -> student.id == id);
            System.out.println("Student deleted successfully!");
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    manager.addStudent(id, name, age);
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    manager.updateStudent(updateId, newName, newAge);
                    break;
                case 4:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
