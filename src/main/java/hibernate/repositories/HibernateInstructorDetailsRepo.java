package hibernate.repositories;

import hibernate.models.HibernateInstructorDetails;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateInstructorDetailsRepo {
    public List<HibernateInstructorDetails> selectAll() {
        List<HibernateInstructorDetails> instructorDetails;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructorDetails = session.createQuery("SELECT i FROM HibernateInstructorDetails i", HibernateInstructorDetails.class).list();
            instructorDetails.forEach(System.out::println);
            session.getTransaction().commit();
        }

        return instructorDetails;
    }

    public void insert(HibernateInstructorDetails instructorDetails) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(instructorDetails);
            session.getTransaction().commit();
        }
    }

    public void delete(HibernateInstructorDetails instructorDetails) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(instructorDetails);
            session.getTransaction().commit();
        }
    }

    public HibernateInstructorDetails getById(int id) {
        HibernateInstructorDetails InstructorDetails;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            InstructorDetails = session.get(HibernateInstructorDetails.class, id);
            session.getTransaction().commit();
        }
        return InstructorDetails;
    }

    public void updateYoutubeChannel(HibernateInstructorDetails instructorDetails) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            instructorDetails.setYoutubeChannel("Changed InstructorDetails Youtube");
            session.update(instructorDetails);
            session.getTransaction().commit();
        }
    }
}
