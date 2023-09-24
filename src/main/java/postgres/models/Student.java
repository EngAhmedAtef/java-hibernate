package postgres.models;

import enums.Gender;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student implements DatabaseModel {
    private String uuid;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String email;
    private String phoneNumber;
    private String nationalId;

    public Student(ResultSet result) throws SQLException {
        uuid = result.getString("id");
        firstName = result.getString("first_name");
        lastName = result.getString("last_name");
        age = result.getInt("age");
        gender = Gender.valueOf(result.getString("gender"));
        email = result.getString("email");
        phoneNumber = result.getString("phone_number");
        nationalId = result.getString("national_id");
    }

    @Override
    public String toString() {
        return "Student{" +
                "uuid='" + uuid + '\'' +
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
