package hibernate.repositories;

import hibernate.entities.InstructorDetails;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class InstructorDetailsRepo {
    public static List<InstructorDetails> selectAll() {
        List<InstructorDetails> instructorDetails;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructorDetails = session.createQuery("SELECT i FROM InstructorDetails i", InstructorDetails.class).list();
            session.getTransaction().commit();
        }

        return instructorDetails;
    }

    public static void insert(InstructorDetails instructorDetails) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(instructorDetails);
            session.getTransaction().commit();
        }
    }

    public static void delete(InstructorDetails instructorDetails) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(instructorDetails);
            session.getTransaction().commit();
        }
    }

    public static InstructorDetails getById(int id) {
        InstructorDetails InstructorDetails;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            InstructorDetails = session.get(hibernate.entities.InstructorDetails.class, id);
            session.getTransaction().commit();
        }
        return InstructorDetails;
    }

    public static void updateYoutubeChannel(InstructorDetails instructorDetails) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructorDetails.setYoutubeChannel("Changed InstructorDetails Youtube");
            session.update(instructorDetails);
            session.getTransaction().commit();
        }
    }
}
