package hibernate.entities;

import enums.Gender;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "national_id")
    private String nationalId;
    @ManyToMany
    @JoinTable(
            name = "relations",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    public Student() {
    }

    public Student(String firstName, String lastName, int age, Gender gender, String email, String phoneNumber, String nationalId, Set<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nationalId = nationalId;
        this.courses = courses;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HibernateStudent{");
        stringBuilder.append("id='").append(id)
                .append(", firstName='").append(firstName)
                .append(", lastName='").append(lastName)
                .append(", age=").append(age)
                .append(", gender=").append(gender)
                .append(", email='").append(email)
                .append(", phoneNumber='").append(phoneNumber)
                .append(", nationalId='").append(nationalId);
        if (courses != null)
            stringBuilder.append(", courses='").append(courses);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
