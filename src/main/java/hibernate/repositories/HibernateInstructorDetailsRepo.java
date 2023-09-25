package hibernate.repositories;

import hibernate.entities.HibernateInstructorDetails;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateInstructorDetailsRepo {
    public static List<HibernateInstructorDetails> selectAll() {
        List<HibernateInstructorDetails> instructorDetails;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructorDetails = session.createQuery("SELECT i FROM HibernateInstructorDetails i", HibernateInstructorDetails.class).list();
//            instructorDetails.forEach(System.out::println);
            session.getTransaction().commit();
        }

        return instructorDetails;
    }

    public static void insert(HibernateInstructorDetails instructorDetails) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(instructorDetails);
            session.getTransaction().commit();
        }
    }

    public static void delete(HibernateInstructorDetails instructorDetails) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(instructorDetails);
            session.getTransaction().commit();
        }
    }

    public static HibernateInstructorDetails getById(int id) {
        HibernateInstructorDetails InstructorDetails;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            InstructorDetails = session.get(HibernateInstructorDetails.class, id);
            session.getTransaction().commit();
        }
        return InstructorDetails;
    }

    public static void updateYoutubeChannel(HibernateInstructorDetails instructorDetails) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructorDetails.setYoutubeChannel("Changed InstructorDetails Youtube");
            session.update(instructorDetails);
            session.getTransaction().commit();
        }
    }
}
