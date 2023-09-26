package hibernate.entities;

import enums.CourseLevel;
import hibernate.dtos.CourseDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "start_date")
    private Timestamp startDate;
    @Column(name = "end_date")
    private Timestamp endDate;
    @Column(name = "course_level")
    @Enumerated(EnumType.STRING)
    private CourseLevel courseLevel;
    @Column(name = "is_started")
    private Boolean isStarted;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    public Course() {}

    public Course(CourseDTO dto) {
        id = dto.getId();
        name = dto.getName();
        startDate = dto.getStartDate();
        endDate = dto.getEndDate();
        courseLevel = dto.getCourseLevel();
        isStarted = dto.getStarted();
        instructor = dto.getInstructor();
        students = dto.getStudents();
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
}