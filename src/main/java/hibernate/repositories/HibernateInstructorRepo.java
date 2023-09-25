package hibernate.repositories;

import hibernate.entities.HibernateInstructor;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateInstructorRepo {

    public static List<HibernateInstructor> selectAll() {
        List<HibernateInstructor> instructors;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructors = session.createQuery("SELECT i FROM HibernateInstructor i", HibernateInstructor.class).list();
//            instructors.forEach(System.out::println);
            session.getTransaction().commit();
        }

        return instructors;
    }

    public static void insert(HibernateInstructor instructor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(instructor);
            session.getTransaction().commit();
        }
    }

    public static void delete(HibernateInstructor instructor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(instructor);
            session.getTransaction().commit();
        }
    }

    public static HibernateInstructor getById(int id) {
        HibernateInstructor instructor;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructor = session.get(HibernateInstructor.class, id);
            session.getTransaction().commit();
        }
        return instructor;
    }

    public static void updateEmail(HibernateInstructor instructor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructor.setEmail("ahmed@gizasystems.com");
            session.update(instructor);
            session.getTransaction().commit();
        }
    }
}