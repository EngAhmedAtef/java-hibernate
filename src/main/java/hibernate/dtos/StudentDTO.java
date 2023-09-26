package hibernate.dtos;

import enums.Gender;
import hibernate.entities.Course;
import hibernate.entities.Student;

import java.util.Set;
import java.util.UUID;

public class StudentDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String email;
    private String phoneNumber;
    private String nationalId;
    private Set<Course> courses;

    public StudentDTO(UUID id, String firstName, String lastName, int age, Gender gender, String email, String phoneNumber, String nationalId, Set<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nationalId = nationalId;
        this.courses = courses;
    }

    public StudentDTO(Student student) {
        id = student.getId();
        firstName = student.getFirstName();
        lastName = student.getLastName();
        age = student.getAge();
        gender = student.getGender();
        email = student.getEmail();
        phoneNumber = student.getPhoneNumber();
        nationalId = student.getNationalId();
        courses = student.getCourses();
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
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }
    public void setCourses(Set<Course> courses) { this.courses = courses; }

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
//        if (courses != null)
//            stringBuilder.append(", courses='").append(courses);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
