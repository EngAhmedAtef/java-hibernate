package hibernate.models;

import enums.Gender;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "students")
public class HibernateStudent {
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
    private Set<HibernateCourse> courses;

    public HibernateStudent() {
    }

    public HibernateStudent(String firstName, String lastName, int age, Gender gender, String email, String phoneNumber, String nationalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nationalId = nationalId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "HibernateStudent{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nationalId='" + nationalId + '\'' +
                '}';
    }
}
