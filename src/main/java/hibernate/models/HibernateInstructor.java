package hibernate.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "instructor")
public class HibernateInstructor {
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
    private List<HibernateCourse> courses;

    public HibernateInstructor() {
    }

    public HibernateInstructor(String firstName, String lastName, String email, String phoneNumber, String title, List<HibernateCourse> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.courses = courses;
    }

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
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
