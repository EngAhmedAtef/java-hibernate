package hibernate.models;

import enums.CourseLevel;
import jakarta.persistence.*;
import postgres.models.Instructor;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "courses")
public class HibernateCourse {
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id")
    private HibernateInstructor instructor;

    public HibernateCourse() {
    }

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
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
