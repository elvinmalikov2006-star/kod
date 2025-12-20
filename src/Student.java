import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private ArrayList<Exam> exams = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exams='" + exams + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public void addExam(Exam exam){
        exams.add(exam);
    }

    public double calculateAverageScore(){
        if (exams.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Exam exam : exams) {
            sum += exam.getScore();
        }
        return (double) sum / exams.size();
    }

    public  boolean hasPassedAllExams(){
        if (exams.isEmpty()){
            return false;
        }
        else {
            for (Exam exam: exams){
                if (!exam.isPassed()){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isPassed(){
        if (exams.isEmpty()) {
            return false;
        }
        return calculateAverageScore() >= 50 && hasPassedAllExams();
    }
}
