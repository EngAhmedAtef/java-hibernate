package hibernate.repositories;

import hibernate.entities.HibernateStudent;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class HibernateStudentRepo {

    public static List<HibernateStudent> selectAll() {
        List<HibernateStudent> students;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            students = session.createQuery("SELECT i FROM HibernateStudent i", HibernateStudent.class).list();
//            students.forEach(System.out::println);
            session.getTransaction().commit();
        }

        return students;
    }

    public static void insert(HibernateStudent student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        }
    }

    public static void delete(HibernateStudent student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(student);
            session.getTransaction().commit();
        }
    }

    public static HibernateStudent getById(UUID id) {
        HibernateStudent student;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            student = session.get(HibernateStudent.class, id);
            session.getTransaction().commit();
        }
        return student;
    }

    public static void updateEmail(HibernateStudent student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            student.setEmail("ahmed@gizasystems.com");
            session.update(student);
            session.getTransaction().commit();
        }
    }
}
