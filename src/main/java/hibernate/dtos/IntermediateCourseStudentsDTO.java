package hibernate.dtos;

import hibernate.entities.Course;
import hibernate.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IntermediateCourseStudentsDTO {

    private String courseName;
    private List<String> students = new ArrayList<>();

    public IntermediateCourseStudentsDTO(Course course) {
        courseName = course.getName();
        Set<Student> students = course.getStudents();
        for (Student student : students)
            this.students.add(student.getFirstName().concat(" ").concat(student.getLastName()));
    }

    public String getCourseName() { return courseName; }
    public List<String> getStudents() { return students; }

    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setStudents(List<String> students) { this.students = students; }

    @Override
    public String toString() {
        return "IntermediateCourseStudentsDTO{" +
                "courseName='" + courseName + '\'' +
                ", students=" + students +
                '}';
    }
}
