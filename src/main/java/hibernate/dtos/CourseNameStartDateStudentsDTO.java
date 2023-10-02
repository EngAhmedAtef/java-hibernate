package hibernate.dtos;

import hibernate.entities.Course;
import hibernate.entities.Student;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CourseNameStartDateStudentsDTO {

    private String courseName;
    private Timestamp startDate;
    private List<String> students = new ArrayList<>();

    public CourseNameStartDateStudentsDTO(Course course) {
        courseName = course.getName();
        startDate = course.getStartDate();
        Set<Student> students = course.getStudents();
        for (Student student : students)
            this.students.add(student.getFirstName().concat(" ").concat(student.getLastName()));
    }

    public String getCourseName() { return courseName; }
    public Timestamp getStartDate() { return startDate; }
    public List<String> getStudents() { return students; }

    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setStartDate(Timestamp startDate) { this.startDate = startDate; }
    public void setStudents(List<String> students) { this.students = students; }

    @Override
    public String toString() {
        return "CourseNameStartDateStudentsDTO{" +
                "courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", students=" + students +
                '}';
    }
}
