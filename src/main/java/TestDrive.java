import enums.CourseLevel;
import hibernate.dtos.InstructorNameCoursesNamesDTO;
import hibernate.entities.*;
import hibernate.repositories.*;
import hibernate.util.HibernateUtil;
//import postgres.data.DatabaseManager;
//import postgres.repository.CRUDRepository;
//import postgres.repository.CoursesRepo;
//import postgres.repository.InstructorsRepo;
//import postgres.repository.StudentsRepo;

//import java.sql.Connection;
//import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TestDrive {
    public static void main(String[] args) {
//        String databaseName = "center_management";
//        String password = "12345";
//
//        DatabaseManager dbManager = new DatabaseManager()
//                .databaseName(databaseName)
//                .password(password);
//
//        Connection dbConnection = dbManager.getConnection();
//
//        try {
//

//            executeInstructorCRUDOperations(dbConnection);
//            executeStudentCRUDOperations(dbConnection);
//            executeCourseCRUDOperations(dbConnection);
//            getInstructorsAndCourses(dbConnection);
//            getInstructorsCoursesStudents(dbConnection);
//            getCourseNameStartDateStudents(dbConnection);
//            getIntermediateCoursesStudents(dbConnection);

//            dbConnection.close();
//        } catch (SQLException e) {
//            System.out.println("An exception occurred.\nError: " + e.getLocalizedMessage());
//        }

//        executeHibernateInstructorCRUDOperations();
//        executeHibernateStudentCRUDOperations();
//        executeHibernateCourseCRUDOperations();
//        executeHibernateInstructorDetailsCRUDOperations();
        executeHibernateJoinsCRUDOperations();

        HibernateUtil.getSessionFactory().close();
    }

    private static void executeHibernateJoinsCRUDOperations() {

        List<InstructorNameCoursesNamesDTO> instructorNameCoursesNames = JoinsRepo.getInstructorsAndCourses();
        instructorNameCoursesNames.forEach(System.out::println);
    }

    private static void executeHibernateInstructorDetailsCRUDOperations() {
        // Get all instructors
        List<InstructorDetails> details = InstructorDetailsRepo.selectAll();
        details.forEach(System.out::println);
    }

    private static void executeHibernateCourseCRUDOperations() {
        // Get all courses
//        List<Course> courses = CourseRepo.selectAll();
//        courses.forEach(System.out::println);

        // Get all course names
//        List<String> names = CourseRepo.selectAllNames();
//        names.forEach(System.out::println);

        // Insert a course
//        Instructor instructor = new Instructor("Ahmed", "Atef", "ahmed@gmail.com", "12345", "Title", null, null);
//        Course course = new Course("My Test Course", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()), CourseLevel.Advanced, false, instructor, null);
//        CourseRepo.insert(course);

        // Get course by id
//        Course course = CourseRepo.getById(UUID.fromString("597cec6e-cb0f-421d-8cf0-691babb8b27d"));
//        System.out.println(course);

        // Get course by name
//        Course course = CourseRepo.getByName("American Romanticism");
//        System.out.println(course);

        // Delete a course
//        CourseRepo.delete(course);

        // Update course name
//        CourseRepo.updateName(UUID.fromString("17d4c753-8ac3-48a5-9d68-be9fb1da5a68"), "American Romanticism");
//        System.out.println(CourseRepo.getById(UUID.fromString("17d4c753-8ac3-48a5-9d68-be9fb1da5a68")));
    }

    private static void executeHibernateStudentCRUDOperations() {
        List<Student> students = StudentRepo.selectAll();
        students.forEach(System.out::println);
    }

    private static void executeHibernateInstructorCRUDOperations() {
        List<Instructor> instructors = InstructorRepo.selectAll();
        instructors.forEach(System.out::println);
    }

//    public static void executeInstructorCRUDOperations(Connection dbConnection) throws SQLException {
//        CRUDRepository instructorRepository = new InstructorsRepo();
//
//        // INSERT QUERY
//        int result = instructorRepository.insertAll(dbConnection);
//        System.out.println("Inserted " + result + " rows in instructor.");
//
//        // UPDATE QUERY
//        result = instructorRepository.updateAll(dbConnection);
//        System.out.println("Updated " + result + " rows in instructor.");
////
////        // SELECT QUERY
//        List<postgres.models.Instructor> instructors = (List<postgres.models.Instructor>) instructorRepository.selectAll(dbConnection);
//        instructors.forEach(System.out::println);
////
////        // DELETE QUERY
//        result = instructorRepository.deleteAll(dbConnection);
//        System.out.println("Deleted " + result + " rows from instructor.");
//    }
//
//    public static void executeStudentCRUDOperations(Connection dbConnection) throws SQLException {
//        CRUDRepository studentRepository = new StudentsRepo();
//
//        // INSERT QUERY
//        int result = studentRepository.insertAll(dbConnection);
//        System.out.println("Inserted " + result + " rows in students.");
//
//        // UPDATE QUERY
//        result = studentRepository.updateAll(dbConnection);
//        System.out.println("Updated " + result + " rows in students.");
////
////        // SELECT QUERY
//        List<postgres.models.Student> students = (List<postgres.models.Student>) studentRepository.selectAll(dbConnection);
//        students.forEach(System.out::println);
////
////        // DELETE QUERY
//        result = studentRepository.deleteAll(dbConnection);
//        System.out.println("Deleted " + result + " rows from students.");
//    }
//
//    public static void executeCourseCRUDOperations(Connection dbConnection) throws SQLException {
//        CRUDRepository courseRepository = new CoursesRepo();
//
//        // INSERT QUERY
//        int result = courseRepository.insertAll(dbConnection);
//        System.out.println("Inserted " + result + " rows in courses.");
//
//        // UPDATE QUERY
//        result = courseRepository.updateAll(dbConnection);
//        System.out.println("Updated " + result + " rows in courses.");
////
////        // SELECT QUERY
//        List<postgres.models.Course> courses = (List<postgres.models.Course>) courseRepository.selectAll(dbConnection);
//        courses.forEach(System.out::println);
////
////        // DELETE QUERY
//        result = courseRepository.deleteAll(dbConnection);
//        System.out.println("Deleted " + result + " rows from courses.");
//    }
}