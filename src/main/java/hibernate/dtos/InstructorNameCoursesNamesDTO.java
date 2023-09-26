package hibernate.dtos;

import hibernate.entities.Course;

import java.util.List;

public class InstructorNameCoursesNamesDTO {
    private String instructorName;
    private List<String> courseNames;
    private List<Course> courses;

    public InstructorNameCoursesNamesDTO(String instructorName, List<Course> courses) {
        this.instructorName = instructorName;
        this.courses = courses;
    }

    public List<String> getCourseNames() {
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
