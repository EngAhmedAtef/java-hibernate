package hibernate.repositories;

import hibernate.dtos.InstructorCourseStudentsDTO;
import hibernate.dtos.InstructorNameCoursesNamesDTO;
import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.mapper.InstructorCourseStudentsMapper;
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
        List<InstructorNameCoursesNamesDTO> result = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Instructor> instructors = session.createQuery("FROM Instructor").getResultList();
            if (!instructors.isEmpty()) {
                InstructorNameCourseNameMapper mapper = new InstructorNameCourseNameMapper();
                for (Instructor instructor : instructors)
                    result.add(mapper.mapToDTO(instructor));
            }
        }

        return result;
    }

    public static List<InstructorCourseStudentsDTO> getInstructorsCoursesStudents() {
        List<InstructorCourseStudentsDTO> result = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Instructor> instructors = session.createQuery("FROM Instructor").getResultList();
            if (!instructors.isEmpty()) {
                InstructorCourseStudentsMapper mapper = new InstructorCourseStudentsMapper();
                for (Instructor instructor : instructors)
                    result.add(mapper.mapToDTO(instructor));
            }
        }

        return result;
    }

    public static void getCourseNameStartDateStudents(Connection dbConnection) throws SQLException {
        List<InstructorCourseStudentsDTO> result = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Instructor> instructors = session.createQuery("FROM Instructor").getResultList();
            if (!instructors.isEmpty()) {
                InstructorCourseStudentsMapper mapper = new InstructorCourseStudentsMapper();
                for (Instructor instructor : instructors)
                    result.add(mapper.mapToDTO(instructor));
            }
        }

        return result;
//
//        PreparedStatement joinQuery = dbConnection.prepareStatement("SELECT name AS course_name, start_date, CONCAT(first_name, ' ', last_name) AS student_name FROM courses JOIN relations ON courses.id = relations.course_id JOIN students ON relations.student_id = students.id ORDER BY course_name");
//        ResultSet result = joinQuery.executeQuery();
//
//        while (result.next())
//            System.out.println("Course: " + result.getString("course_name") + " | Start Date: " + result.getTimestamp("start_date") + " | Student: " + result.getString("student_name"));
    }

    public static void getIntermediateCoursesStudents(Connection dbConnection) throws SQLException {
        PreparedStatement joinQuery = dbConnection.prepareStatement("SELECT name AS course_name, course_level, CONCAT(first_name, ' ', last_name) AS student_name FROM courses JOIN relations ON courses.id = relations.course_id JOIN students ON relations.student_id = students.id WHERE course_level = 'Intermediate' ORDER BY course_name");
        ResultSet result = joinQuery.executeQuery();

        while (result.next())
            System.out.println("Course: " + result.getString("course_name") + " | Course Level: " + result.getString("course_level") + " | Student: " + result.getString("student_name"));
    }

}
