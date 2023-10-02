import hibernate.dtos.CourseNameStartDateStudentsDTO;
import hibernate.dtos.InstructorCourseStudentsDTO;
import hibernate.dtos.InstructorNameCoursesNamesDTO;
import hibernate.dtos.IntermediateCourseStudentsDTO;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import hibernate.entities.Student;
import hibernate.mapper.IntermediateCourseStudentsMapper;
import hibernate.repositories.InstructorDetailsRepo;
import hibernate.repositories.InstructorRepo;
import hibernate.repositories.JoinsRepo;
import hibernate.repositories.StudentRepo;
import hibernate.util.HibernateUtil;

import java.util.List;

public class TestDrive {
    public static void main(String[] args) {

//        executeHibernateInstructorCRUDOperations();
//        executeHibernateStudentCRUDOperations();
//        executeHibernateCourseCRUDOperations();
//        executeHibernateInstructorDetailsCRUDOperations();
        executeHibernateJoinsCRUDOperations();

        HibernateUtil.getSessionFactory().close();
    }

    private static void executeHibernateJoinsCRUDOperations() {
//        List<InstructorNameCoursesNamesDTO> result = JoinsRepo.getInstructorsAndCourses();
//        result.forEach(System.out::println);

//        List<InstructorCourseStudentsDTO> result = JoinsRepo.getInstructorsCoursesStudents();
//        result.forEach(System.out::println);

//        List<CourseNameStartDateStudentsDTO> result = JoinsRepo.getCourseNameStartDateStudents();
//        result.forEach(System.out::println);

        List<IntermediateCourseStudentsDTO> result = JoinsRepo.getIntermediateCoursesStudents();
        result.forEach(System.out::println);
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
}