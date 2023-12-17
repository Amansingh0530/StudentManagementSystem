package studentManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add Student\n2. Remove Student\n3. Record Grades\n4. Calculate GPA\n5. Generate Report\n0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    recordGrades();
                    break;
                case 4:
                    calculateGPA();
                    break;
                case 5:
                    generateReport();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        students.add(new Student(name));
        System.out.println("Student added successfully.");
    }

    static void removeStudent() {
        System.out.print("Enter student name to remove: ");
        String name = scanner.next();
        students.removeIf(student -> student.name.equals(name));
        System.out.println("Student removed successfully.");
    }

    static void recordGrades() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        for (Student student : students) {
            if (student.name.equals(name)) {
                System.out.print("Enter grade (enter -1 to stop): ");
                int grade;
                while ((grade = scanner.nextInt()) != -1) {
                    student.grades.add(grade);
                }
                System.out.println("Grades recorded successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void calculateGPA() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        for (Student student : students) {
            if (student.name.equals(name)) {
                if (student.grades.isEmpty()) {
                    System.out.println("No grades recorded for this student.");
                } else {
                    double sum = 0;
                    for (int grade : student.grades) {
                        sum += grade;
                    }
                    double gpa = sum / student.grades.size();
                    System.out.println("GPA for " + student.name + ": " + gpa);
                }
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void generateReport() {
        System.out.println("Student Report:");
        for (Student student : students) {
            System.out.println("Name: " + student.name);
            System.out.println("Grades: " + student.grades);
            System.out.println();
        }
    }
}
