package hibernate.entities;

import hibernate.dtos.InstructorDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER)
    private List<Course> courses;
    @OneToOne(mappedBy = "instructor")
    private InstructorDetails details;

    public Instructor() {}

    public Instructor(InstructorDTO dto) {
        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        email = dto.getEmail();
        phoneNumber = dto.getPhoneNumber();
        title = dto.getTitle();
        courses = dto.getCourses();
        details = dto.getDetails();
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getTitle() { return title; }
    public List<Course> getCourses() { return courses; }
    public InstructorDetails getDetails() { return details; }

    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setTitle(String title) { this.title = title; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
    public void setDetails(InstructorDetails details) { this.details = details; }
    public void setEmail(String email) { this.email = email; }
}
