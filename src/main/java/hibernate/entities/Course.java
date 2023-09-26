package hibernate.entities;

import enums.CourseLevel;
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

    public Course(String name, Timestamp startDate, Timestamp endDate, CourseLevel courseLevel, Boolean isStarted, Instructor instructor, Set<Student> students) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseLevel = courseLevel;
        this.isStarted = isStarted;
        this.instructor = instructor;
        this.students = students;
    }

    public String getName() { return name; }

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
