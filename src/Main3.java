import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(){
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true){
            System.out.println("1. Add student");
            System.out.println("2. Add exam to student");
            System.out.println("3. Show all students");
            System.out.println("4. Show pass/fail status");
            System.out.println("5. Show top student");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            if (choice == 0){
                break;
            }

            switch (choice){
                case 1:
                    System.out.println("Student ID:");
                    int id = scanner.nextInt();
                    System.out.println("Student name:");
                    String name = scanner.next();
                    service.addStudent(new Student(id, name));
                    break;

                case 2:
                    System.out.println("Student ID:");
                    int studentId = scanner.nextInt();
                    var student = service.findStudentById(studentId);
                    student.addExam(new Exam());
                    break;

                case 3:
                    System.out.println(service.students);
                    break;

                case 4:
                    System.out.println("Student id:");
                    int s = scanner.nextInt();
                    var st = service.findStudentById(s);
                    System.out.println(st.hasPassedAllExams());
                    break;

                case 5:
                    System.out.println(service.findTopStudent());
                    break;

                default:
                    System.out.println("Invalid choice:");
            }
        }
    }
}
