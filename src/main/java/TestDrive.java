import hibernate.entities.HibernateCourse;
import hibernate.entities.HibernateInstructor;
import hibernate.entities.HibernateInstructorDetails;
import hibernate.entities.HibernateStudent;
import hibernate.repositories.*;
import postgres.data.DatabaseManager;
import postgres.models.Course;
import postgres.models.Instructor;
import postgres.models.Student;
import postgres.repository.CRUDRepository;
import postgres.repository.CoursesRepo;
import postgres.repository.InstructorsRepo;
import postgres.repository.StudentsRepo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestDrive {
    public static void main(String[] args) {
        String databaseName = "center_management";
        String password = "12345";

        DatabaseManager dbManager = new DatabaseManager()
                .databaseName(databaseName)
                .password(password);

        Connection dbConnection = dbManager.getConnection();

        try {
//            executeHibernateInstructorCRUDOperations();
//            executeHibernateStudentCRUDOperations();
//            executeHibernateCourseCRUDOperations();
//            executeHibernateInstructorDetailsCRUDOperations();
            executeHibernateJoinsCRUDOperations();

//            executeInstructorCRUDOperations(dbConnection);
//            executeStudentCRUDOperations(dbConnection);
//            executeCourseCRUDOperations(dbConnection);
//            getInstructorsAndCourses(dbConnection);
//            getInstructorsCoursesStudents(dbConnection);
//            getCourseNameStartDateStudents(dbConnection);
//            getIntermediateCoursesStudents(dbConnection);

            dbConnection.close();
        } catch (SQLException e) {
            System.out.println("An exception occurred.\nError: " + e.getLocalizedMessage());
        }
    }

    private static void executeHibernateJoinsCRUDOperations() {
        HibernateJoinsRepo.getInstructorsAndCourses();
    }
    private static void executeHibernateInstructorDetailsCRUDOperations() {
        List<HibernateInstructorDetails> details = HibernateInstructorDetailsRepo.selectAll();
        details.forEach(System.out::println);
    }
    private static void executeHibernateCourseCRUDOperations() {
        List<HibernateCourse> courses = HibernateCourseRepo.selectAll();
        courses.forEach(System.out::println);
//        HibernateInstructor instructor = new HibernateInstructor("Ahmed", "Atef", "ahmed@gmail.com", "12345", "My Title", null, null);
//        HibernateCourse course = new HibernateCourse("My Course", Timestamp.valueOf("2023-06-01 12:00:00"), Timestamp.valueOf("2023-06-01 12:00:00"), CourseLevel.Advanced, false, instructor, null);
//        HibernateCourseRepo.insert(course);
    }
    private static void executeHibernateStudentCRUDOperations() {
        List<HibernateStudent> students = HibernateStudentRepo.selectAll();
        students.forEach(System.out::println);
    }

    private static void executeHibernateInstructorCRUDOperations() {
        List<HibernateInstructor> instructors = HibernateInstructorRepo.selectAll();
        instructors.forEach(System.out::println);
    }

    public static void executeInstructorCRUDOperations(Connection dbConnection) throws SQLException {
        CRUDRepository instructorRepository = new InstructorsRepo();

        // INSERT QUERY
        int result = instructorRepository.insertAll(dbConnection);
        System.out.println("Inserted " + result + " rows in instructor.");

        // UPDATE QUERY
        result = instructorRepository.updateAll(dbConnection);
        System.out.println("Updated " + result + " rows in instructor.");
//
//        // SELECT QUERY
        List<Instructor> instructors = (List<Instructor>) instructorRepository.selectAll(dbConnection);
        instructors.forEach(System.out::println);
//
//        // DELETE QUERY
        result = instructorRepository.deleteAll(dbConnection);
        System.out.println("Deleted " + result + " rows from instructor.");
    }

    public static void executeStudentCRUDOperations(Connection dbConnection) throws SQLException {
        CRUDRepository studentRepository = new StudentsRepo();

        // INSERT QUERY
        int result = studentRepository.insertAll(dbConnection);
        System.out.println("Inserted " + result + " rows in students.");

        // UPDATE QUERY
        result = studentRepository.updateAll(dbConnection);
        System.out.println("Updated " + result + " rows in students.");
//
//        // SELECT QUERY
        List<Student> students = (List<Student>) studentRepository.selectAll(dbConnection);
        students.forEach(System.out::println);
//
//        // DELETE QUERY
        result = studentRepository.deleteAll(dbConnection);
        System.out.println("Deleted " + result + " rows from students.");
    }

    public static void executeCourseCRUDOperations(Connection dbConnection) throws SQLException {
        CRUDRepository courseRepository = new CoursesRepo();

        // INSERT QUERY
        int result = courseRepository.insertAll(dbConnection);
        System.out.println("Inserted " + result + " rows in courses.");

        // UPDATE QUERY
        result = courseRepository.updateAll(dbConnection);
        System.out.println("Updated " + result + " rows in courses.");
//
//        // SELECT QUERY
        List<Course> courses = (List<Course>) courseRepository.selectAll(dbConnection);
        courses.forEach(System.out::println);
//
//        // DELETE QUERY
        result = courseRepository.deleteAll(dbConnection);
        System.out.println("Deleted " + result + " rows from courses.");
    }
}