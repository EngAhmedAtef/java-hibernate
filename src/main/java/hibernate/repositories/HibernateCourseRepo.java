package hibernate.repositories;

import hibernate.entities.HibernateCourse;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateCourseRepo {

    public static List<HibernateCourse> selectAll() {
        List<HibernateCourse> courses;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            courses = session.createQuery("SELECT i FROM HibernateCourse i", HibernateCourse.class).list();
//            courses.forEach(System.out::println);
            session.getTransaction().commit();
        }

        return courses;
    }

    public static void insert(HibernateCourse course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
        }
    }

    public static void delete(HibernateCourse course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(course);
            session.getTransaction().commit();
        }
    }

    public static HibernateCourse getById(int id) {
        HibernateCourse Course;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Course = session.get(HibernateCourse.class, id);
            session.getTransaction().commit();
        }
        return Course;
    }

    public static void updateEmail(HibernateCourse course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            course.setName("Changed Course Name");
            session.update(course);
            session.getTransaction().commit();
        }
    }
}
