package hibernate.repositories;

import hibernate.entities.Instructor;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class InstructorRepo {

    public static List<Instructor> selectAll() {
        List<Instructor> instructors;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructors = session.createQuery("FROM Instructor", Instructor.class).list();
            session.getTransaction().commit();
        }

        return instructors;
    }

    public static void insert(Instructor instructor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(instructor);
            session.getTransaction().commit();
        }
    }

    public static void delete(Instructor instructor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(instructor);
            session.getTransaction().commit();
        }
    }

    public static Instructor getById(int id) {
        Instructor instructor;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructor = session.get(Instructor.class, id);
            session.getTransaction().commit();
        }
        return instructor;
    }

    public static void updateEmail(Instructor instructor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructor.setEmail("ahmed@gizasystems.com");
            session.update(instructor);
            session.getTransaction().commit();
        }
    }
}