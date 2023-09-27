package hibernate.dtos;

import hibernate.entities.Course;
import hibernate.entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorNameCoursesNamesDTO {

    private String instructorName;
    private List<String> courseNames;

    public InstructorNameCoursesNamesDTO(Instructor instructor) {
        instructorName = instructor.getFirstName().concat(" " + instructor.getLastName());
        courseNames = new ArrayList<>();
        for (Course course : instructor.getCourses())
            courseNames.add(course.getName());
    }

    public String getInstructorName() { return instructorName; }
    public List<String> getCourseNames() { return courseNames; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }
    public void setCourseNames(List<String> courseNames) { this.courseNames = courseNames; }

    @Override
    public String toString() {
        return "InstructorNameCoursesNamesDTO{" +
                "instructorName='" + instructorName + '\'' +
                ", courseNames=" + courseNames +
                '}';
    }
}
