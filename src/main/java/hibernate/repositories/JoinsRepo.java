package hibernate.repositories;

import hibernate.dtos.InstructorNameCoursesNamesDTO;
import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.mapper.InstructorMapper;
import hibernate.mapper.InstructorNameCourseNameMapper;
import hibernate.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoinsRepo {

    public static List<InstructorNameCoursesNamesDTO> getInstructorsAndCourses() {
        List<InstructorNameCoursesNamesDTO> instructorNamesCoursesNames = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Instructor> instructors = session.createQuery("FROM Instructor").getResultList();
            if (!instructors.isEmpty()) {
                InstructorNameCourseNameMapper mapper = new InstructorNameCourseNameMapper();
                for (Instructor instructor : instructors)
                    instructorNamesCoursesNames.add(mapper.mapToDTO(instructor));
            }
        }

        return instructorNamesCoursesNames;
    }

    public static void getInstructorsCoursesStudents(Connection dbConnection) throws SQLException {
        PreparedStatement joinQuery = dbConnection.prepareStatement("SELECT CONCAT(instructor.first_name, ' ', instructor.last_name) AS instructor_name, name AS course_name, CONCAT(students.first_name, ' ', students.last_name) AS student_name FROM instructor JOIN courses ON instructor.id = courses.instructor_id JOIN relations ON courses.id = relations.course_id JOIN students ON relations.student_id = students.id ORDER BY instructor_name");
        ResultSet result = joinQuery.executeQuery();

        while (result.next())
            System.out.println("Instructor: " + result.getString("instructor_name") + " | Course: " + result.getString("course_name") + " | Student: " + result.getString("student_name"));

    }

    public static void getCourseNameStartDateStudents(Connection dbConnection) throws SQLException {
        PreparedStatement joinQuery = dbConnection.prepareStatement("SELECT name AS course_name, start_date, CONCAT(first_name, ' ', last_name) AS student_name FROM courses JOIN relations ON courses.id = relations.course_id JOIN students ON relations.student_id = students.id ORDER BY course_name");
        ResultSet result = joinQuery.executeQuery();

        while (result.next())
            System.out.println("Course: " + result.getString("course_name") + " | Start Date: " + result.getTimestamp("start_date") + " | Student: " + result.getString("student_name"));
    }

    public static void getIntermediateCoursesStudents(Connection dbConnection) throws SQLException {
        PreparedStatement joinQuery = dbConnection.prepareStatement("SELECT name AS course_name, course_level, CONCAT(first_name, ' ', last_name) AS student_name FROM courses JOIN relations ON courses.id = relations.course_id JOIN students ON relations.student_id = students.id WHERE course_level = 'Intermediate' ORDER BY course_name");
        ResultSet result = joinQuery.executeQuery();

        while (result.next())
            System.out.println("Course: " + result.getString("course_name") + " | Course Level: " + result.getString("course_level") + " | Student: " + result.getString("student_name"));
    }

}
