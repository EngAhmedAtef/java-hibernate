package hibernate.repositories;

import hibernate.models.HibernateCourse;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateCourseRepo {

    public List<HibernateCourse> selectAll() {
        List<HibernateCourse> Courses;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Courses = session.createQuery("SELECT i FROM HibernateCourse i", HibernateCourse.class).list();
            Courses.forEach(System.out::println);
            session.getTransaction().commit();
        }

        return Courses;
    }

    public void insert(HibernateCourse Course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(Course);
            session.getTransaction().commit();
        }
    }

    public void delete(HibernateCourse Course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(Course);
            session.getTransaction().commit();
        }
    }

    public HibernateCourse getById(int id) {
        HibernateCourse Course;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Course = session.get(HibernateCourse.class, id);
            session.getTransaction().commit();
        }
        return Course;
    }

    public void updateEmail(HibernateCourse Course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Course.setName("Changed Course Name");
            session.update(Course);
            session.getTransaction().commit();
        }
    }
}
