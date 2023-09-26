package hibernate.dtos;

import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;

import java.util.List;

public class InstructorDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String title;
    private List<Course> courses;
    private InstructorDetails details;


    public InstructorDTO(int id, String firstName, String lastName, String email, String phoneNumber, String title, List<Course> courses, InstructorDetails details) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.courses = courses;
        this.details = details;
    }

    public InstructorDTO(Instructor instructor) {
        id = instructor.getId();
        firstName = instructor.getFirstName();
        lastName = instructor.getLastName();
        email = instructor.getEmail();
        phoneNumber = instructor.getPhoneNumber();
        title = instructor.getTitle();
        courses = instructor.getCourses();
        details = instructor.getDetails();
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
