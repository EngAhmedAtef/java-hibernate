package hibernate.repositories;

import enums.CourseLevel;
import hibernate.dtos.CourseNameStartDateStudentsDTO;
import hibernate.dtos.InstructorCourseStudentsDTO;
import hibernate.dtos.InstructorNameCoursesNamesDTO;
import hibernate.dtos.IntermediateCourseStudentsDTO;
import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.mapper.*;
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

    public static List<CourseNameStartDateStudentsDTO> getCourseNameStartDateStudents() {
        List<CourseNameStartDateStudentsDTO> result = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Course> courses = session.createQuery("FROM Course").getResultList();

            if (!courses.isEmpty()) {
                CourseNameStartDateStudentsMapper mapper = new CourseNameStartDateStudentsMapper();
                for (Course course : courses)
                    result.add(mapper.mapToDTO(course));
            }
        }

        return result;
    }

    public static List<IntermediateCourseStudentsDTO> getIntermediateCoursesStudents() {
        List<IntermediateCourseStudentsDTO> result = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Course> courses = session.createQuery("FROM Course c WHERE CAST(c.courseLevel AS string) = :level")
                    .setParameter("level", CourseLevel.Intermediate.name())
                    .getResultList();

            if (!courses.isEmpty()) {
                IntermediateCourseStudentsMapper mapper = new IntermediateCourseStudentsMapper();
                for (Course course : courses)
                    result.add(mapper.mapToDTO(course));
            }
        }

        return result;
    }

}
