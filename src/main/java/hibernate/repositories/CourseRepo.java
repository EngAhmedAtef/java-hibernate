package hibernate.repositories;

import hibernate.entities.Course;
import hibernate.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class CourseRepo {

    public static List<Course> selectAll() {
        List<Course> courses;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            courses = session.createQuery("FROM Course", Course.class).list();
        }

        return courses;
    }

    public static List<String> selectAllNames() {
        List<String> names;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            names = session.createQuery("SELECT c.name FROM Course c", String.class).list();
        }

        return names;
    }

    public static void insert(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
            System.out.println("Inserted the course " + course.getName());
        }
    }

    public static void delete(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(course);
            session.getTransaction().commit();
            System.out.println("Deleted course " + course.getName());
        }
    }

    public static Course getById(UUID id) {
        Course course;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            course = session.get(hibernate.entities.Course.class, id);
        }
        return course;
    }

    public static Course getByName(String name) {
        Course course;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Course c WHERE c.name = :name");
            query.setParameter("name", name);
            course = (Course) query.getSingleResult();
        }
        return course;
    }

    public static void updateName(UUID id, String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("UPDATE Course SET name = :newName WHERE id = :id");
            query.setParameter("newName", name);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Updated " + result + " rows.");
        }
    }
}
