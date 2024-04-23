import java.util.Scanner;
import java.util.ArrayList;
class Student 
{
    private String name;
    private int rollNumber;
    private String grade;
    public Student(String name,int rollNumber,String grade) 
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    public String getName() 
    {
        return name;
    }
    public int getRollNumber() 
    {
        return rollNumber;
    }
    public String getGrade() 
    {
        return grade;
    }
    public String toString() 
    {
        return "Name:"+name+",Roll Number:"+rollNumber+",Grade:"+grade;
    }
}
class StudentManagementSystem 
{
    private ArrayList<Student>students;
    public StudentManagementSystem() 
    {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) 
    {
        students.add(student);
    }
    public void removeStudent(int rollNumber) 
    {
        for (int i=0;i<students.size();i++) 
        {
            if (students.get(i).getRollNumber()==rollNumber) 
            {
                students.remove(i);
                return;
            }
        }
        System.out.println("Student with roll number "+rollNumber+" not found.");
    }
    public Student searchStudent(int rollNumber) 
    {
        for (Student student : students) 
        {
            if (student.getRollNumber()==rollNumber) 
            {
                return student;
            }
        }
        return null;
    }
    public void displayAllStudents() 
    {
        for (Student student:students) 
        {
            System.out.println(student);
        }
    }
}
public class StudentsManagementSystem 
{
    public static void main(String[]args) 
    {
        try(Scanner scanner = new Scanner(System.in))
        {
            StudentManagementSystem sms=new StudentManagementSystem();
            while(true) 
            {
                System.out.println("\nStudent Management System");
                System.out.println("1.Add Student");
                System.out.println("2.Remove Student");
                System.out.println("3.Search Student");
                System.out.println("4.Display All Students");
                System.out.println("5.Exit");
                System.out.print("Enter your choice:");
                int choice = scanner.nextInt();
                switch(choice) 
                {
                    case 1:
                        System.out.print("Enter student name:");
                        scanner.nextLine(); 
                        String name=scanner.nextLine();
                        System.out.print("Enter roll number:");
                        int rollNumber=scanner.nextInt();
                        System.out.print("Enter grade:");
                        String grade=scanner.next();
                        sms.addStudent(new Student(name, rollNumber, grade));
                        break;
                    case 2:
                        System.out.print("Enter roll number of student to remove:");
                        int rollToRemove=scanner.nextInt();
                        sms.removeStudent(rollToRemove);
                        break;
                    case 3:
                        System.out.print("Enter roll number of student to search:");
                        int rollToSearch=scanner.nextInt();
                        Student foundStudent=sms.searchStudent(rollToSearch);
                        if (foundStudent!=null) 
                        {
                            System.out.println("Student found:");
                            System.out.println(foundStudent);
                        }
                        else 
                        {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 4:
                        System.out.println("All Students:");
                        sms.displayAllStudents();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.Please enter a number from 1 to 5.");
                }
            }
        }
    }
}
