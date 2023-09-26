package hibernate.dtos;

import enums.CourseLevel;
import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.entities.Student;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

public class CourseDTO {
    private UUID id;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private CourseLevel courseLevel;
    private Boolean isStarted;
    private Instructor instructor;
    private Set<Student> students;

    public CourseDTO(UUID id, String name, Timestamp startDate, Timestamp endDate, CourseLevel courseLevel, Boolean isStarted, Instructor instructor, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseLevel = courseLevel;
        this.isStarted = isStarted;
        this.instructor = instructor;
        this.students = students;
    }

    public CourseDTO(Course course) {
        id = course.getId();
        name = course.getName();
        startDate = course.getStartDate();
        endDate = course.getEndDate();
        courseLevel = course.getCourseLevel();
        isStarted = course.getStarted();
        instructor = course.getInstructor();
        students = course.getStudents();
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public Timestamp getStartDate() { return startDate; }
    public Timestamp getEndDate() { return endDate; }
    public CourseLevel getCourseLevel() { return courseLevel; }
    public Boolean getStarted() { return isStarted; }
    public Instructor getInstructor() {  return instructor; }
    public Set<Student> getStudents() { return students; }

    public void setId(UUID id) { this.id = id; }
    public void setStartDate(Timestamp startDate) { this.startDate = startDate; }
    public void setEndDate(Timestamp endDate) { this.endDate = endDate; }
    public void setCourseLevel(CourseLevel courseLevel) { this.courseLevel = courseLevel; }
    public void setStarted(Boolean started) { isStarted = started; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public void setStudents(Set<Student> students) { this.students = students; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HibernateCourse{");
        stringBuilder.append("id=").append(id)
                .append(", name='").append(name)
                .append(", startDate=").append(startDate)
                .append(", endDate=").append(endDate)
                .append(", courseLevel=").append(courseLevel)
                .append(", isStarted=").append(isStarted);
//        if (instructor != null)
//            stringBuilder.append(", instructor=").append(instructor);
//        if (students != null)
//            stringBuilder.append(", students=").append(students);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
