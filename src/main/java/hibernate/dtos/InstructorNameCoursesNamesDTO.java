package hibernate.dtos;

import hibernate.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class InstructorNameCoursesNamesDTO {
    private String instructorName;
    private List<Course> courseNames = new ArrayList<>();

    public InstructorNameCoursesNamesDTO(String instructorName, List<Course> courseNames) {
        this.instructorName = instructorName;
        this.courseNames = courseNames;
    }

    public InstructorNameCoursesNamesDTO(String instructorName, Course course) {
        this.instructorName = instructorName;
        courseNames.add(course);
    }

    public List<Course> getCourseNames() {
        return courseNames;
    }

    public String getInstructorName() {
        return instructorName;
    }

    @Override
    public String toString() {
        return "InstructorNameCoursesNamesDTO{" +
                "instructorName='" + instructorName + '\'' +
                ", courseNames=" + courseNames +
                '}';
    }
}
