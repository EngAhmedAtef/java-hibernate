package hibernate.dtos;

import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.entities.Student;

import java.util.*;

public class InstructorCourseStudentsDTO {

    private String instructorName;
    private Map<String, List<String>> courseStudents = new HashMap<>();

    public InstructorCourseStudentsDTO(Instructor instructor) {
        instructorName = instructor.getFirstName().concat(" ").concat(instructor.getLastName());
        List<Course> courses = instructor.getCourses();
        for (Course course : courses) {
            List<String> studentNames = new ArrayList<>();
            Set<Student> students = course.getStudents();
            for (Student student : students)
                studentNames.add(student.getFirstName().concat(" ").concat(student.getLastName()));
            courseStudents.put(course.getName(), studentNames);
        }
    }

    public String getInstructorName() { return instructorName; }
    public Map<String, List<String>> getCourseStudents() { return courseStudents; }

    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }
    public void setCourseStudents(Map<String, List<String>> courseStudents) { this.courseStudents = courseStudents; }

    @Override
    public String toString() {
        return "InstructorCourseStudentsDTO{" +
                "instructorName='" + instructorName + '\'' +
                ", courseStudents=" + courseStudents +
                '}';
    }
}
