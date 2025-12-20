import java.util.ArrayList;

public class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public  void addStudent(Student student){
        students.add(student);
    }

    public Student findTopStudent(){
        var topStudent = students.get(0);
        for (Student student: students){
            if (student.calculateAverageScore() < topStudent.getId()){
                topStudent = student;
            }
        }
        return topStudent;
    }
}
