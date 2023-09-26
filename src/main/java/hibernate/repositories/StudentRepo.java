package hibernate.repositories;

import hibernate.entities.Student;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class StudentRepo {

    public static List<Student> selectAll() {
        List<Student> students;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            students = session.createQuery("SELECT i FROM HibernateStudent i", Student.class).list();
            session.getTransaction().commit();
        }

        return students;
    }

    public static void insert(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        }
    }

    public static void delete(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(student);
            session.getTransaction().commit();
        }
    }

    public static Student getById(UUID id) {
        Student student;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            student = session.get(Student.class, id);
            session.getTransaction().commit();
        }
        return student;
    }

    public static void updateEmail(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            student.setEmail("ahmed@gizasystems.com");
            session.update(student);
            session.getTransaction().commit();
        }
    }
}
