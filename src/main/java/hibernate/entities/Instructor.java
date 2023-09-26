package hibernate.entities;

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

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email, String phoneNumber, String title, List<Course> courses, InstructorDetails details) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.courses = courses;
        this.details = details;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getTitle() { return title; }
    public List<Course> getCourses() { return courses; }
    public InstructorDetails getDetails() { return details; }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HibernateInstructor{");
        stringBuilder.append("id=").append(id)
                .append(", firstName='").append(firstName)
                .append(", lastName='").append(lastName)
                .append(", email='").append(email)
                .append(", phoneNumber='").append(phoneNumber)
                .append(", title='").append(title);
//        if (courses != null)
//            stringBuilder.append(", courses=").append(courses);
//        if (details != null)
//            stringBuilder.append(", details=").append(details);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
