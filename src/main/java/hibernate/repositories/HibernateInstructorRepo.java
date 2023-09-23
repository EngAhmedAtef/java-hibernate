package hibernate.repositories;

import hibernate.models.HibernateInstructor;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateInstructorRepo {

    public List<HibernateInstructor> selectAll() {
        List<HibernateInstructor> instructors;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructors = session.createQuery("SELECT i FROM HibernateInstructor i", HibernateInstructor.class).list();
            instructors.forEach(System.out::println);
            session.getTransaction().commit();
        }

        return instructors;
    }

    public void insert(HibernateInstructor instructor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(instructor);
            session.getTransaction().commit();
        }
    }

    public void delete(HibernateInstructor instructor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(instructor);
            session.getTransaction().commit();
        }
    }

    public HibernateInstructor getById(int id) {
        HibernateInstructor instructor = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructor = session.get(HibernateInstructor.class, id);
            session.getTransaction().commit();
        }
        return instructor;
    }

    public void updateEmail(HibernateInstructor instructor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructor.setEmail("ahmed@gizasystems.com");
            session.update(instructor);
            session.getTransaction().commit();
        }
    }
}