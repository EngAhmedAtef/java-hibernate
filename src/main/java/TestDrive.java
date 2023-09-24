import enums.Gender;
import hibernate.models.HibernateInstructor;
import hibernate.models.HibernateStudent;
import hibernate.repositories.HibernateInstructorRepo;
import hibernate.repositories.HibernateStudentRepo;
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
import java.util.UUID;

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

    private static void executeHibernateStudentCRUDOperations() {
        HibernateStudentRepo hibernateStudentRepo = new HibernateStudentRepo();
//        hibernateStudentRepo.selectAll();

//        HibernateStudent student =
//                new HibernateStudent("Ahmed", "Atef", 24, Gender.Male, "ahmed@gmail.com", "01090275978", "EG1234567689");
//        hibernateStudentRepo.insert(student);
//        HibernateStudent student = hibernateStudentRepo.getById(UUID.fromString("a5fabb6d-0162-4fd2-9941-b572ce0518cc"));
//        hibernateStudentRepo.updateEmail(student);
//        hibernateStudentRepo.delete(student);
//        hibernateStudentRepo.selectAll();
    }

    private static void executeHibernateInstructorCRUDOperations() {
        HibernateInstructorRepo hibernateInstructorRepository = new HibernateInstructorRepo();

//        HibernateInstructor instructor =
//                new HibernateInstructor("Ahmed", "Atef", "ahmed@gmail.com", "01090275978", "Software Developer");
//        hibernateInstructorRepository.insert(instructor);
        hibernateInstructorRepository.selectAll();
//        HibernateInstructor instructor = hibernateInstructorRepository.getById(23);
//        hibernateInstructorRepository.updateEmail(instructor);
//        System.out.println(instructor);
//        hibernateInstructorRepository.delete(instructor);
//        hibernateInstructorRepository.selectAll();
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