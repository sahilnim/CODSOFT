import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//Create student class
public class Student {
    private String name;
    private int rollNumber;
    private String grade;

    // Constructors, getters, and setters

    public Student(String name, int rollNumber, String grade) 
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

//Override toString method for better coding effects
    @Override
    public String toString() 
    {
        return "Student{"+"name=" +name+ '\'' + ", rollno=" +rollNumber+", grade=" +grade+ '\''+'}';    
    }
}

//create a class student management system

public class StudentManagementSystem
{
    private List<Student> students;

    public StudentManagementSystem()
    {
        this.students=new ArrayList<>();
    }
    public void addStudent(Student student)
    {
        students.add(student);
    }
    public void removeStudent(Student student)
    {
        students.remove(student);
    }
    public Student searchStudent(int rollno)
    {
        for(Student student : students) 
        {
            if (student.getRollNumber() == rollno) 
            {
                return student;    
            }
        }
        return null;
    }
    public void displayAllStudents()
    {
        for(Student student : students)
        {
            System.out.println(student);
        }
    }
}

//MAIN METHOD
public class StudentManagementSystemUI {
    
    public static void main(String[] args) 
    {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    String grade = scanner.next();

                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    // Remove Student
                    System.out.print("Enter roll number of student to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    Student studentToRemove = system.searchStudent(removeRollNumber);

                    if (studentToRemove != null) {
                        system.removeStudent(studentToRemove);
                        System.out.println("Student removed successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    // Search Student
                    System.out.print("Enter roll number of student to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student foundStudent = system.searchStudent(searchRollNumber);

                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Display All Students
                    system.displayAllStudents();
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);

        // Close the scanner
        scanner.close();
    }
}    
