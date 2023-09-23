package postgres.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Instructor implements DatabaseModel {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String title;

    public Instructor(ResultSet result) throws SQLException {
        id = result.getInt("id");
        firstName = result.getString("first_name");
        lastName = result.getString("last_name");
        email = result.getString("email");
        phoneNumber = result.getString("phone_number");
        title = result.getString("title");
    }

    @Override
    public String toString() {
        return "model.Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
