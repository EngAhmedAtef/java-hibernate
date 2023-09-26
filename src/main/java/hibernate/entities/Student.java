package hibernate.entities;

import enums.Gender;
import hibernate.dtos.StudentDTO;
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

    public Student() {}

    public Student(StudentDTO dto) {
        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        age = dto.getAge();
        gender = dto.getGender();
        email = dto.getEmail();
        phoneNumber = dto.getPhoneNumber();
        nationalId = dto.getNationalId();
        courses = dto.getCourses();
    }

    public UUID getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public Gender getGender() { return gender; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getNationalId() { return nationalId; }
    public Set<Course> getCourses() { return courses; }

    public void setId(UUID id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }
    public void setCourses(Set<Course> courses) { this.courses = courses; }
    public void setEmail(String email) {
        this.email = email;
    }
}
