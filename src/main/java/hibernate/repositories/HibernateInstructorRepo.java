package hibernate.repositories;

import hibernate.models.HibernateInstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateInstructorRepo {
    private SessionFactory sessionFactory;

    public HibernateInstructorRepo() {

        Configuration config = new Configuration();
        config.addAnnotatedClass(HibernateInstructor.class);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        try {
//            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            sessionFactory = config.buildSessionFactory(registry);
        } catch (Exception e) {
//            StandardServiceRegistryBuilder.destroy(registry);
            if (sessionFactory != null)
                sessionFactory.close();
        }
    }

    public List<HibernateInstructor> selectAll() {
        List<HibernateInstructor> instructors;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            instructors = session.createQuery("SELECT i FROM HibernateInstructor i", HibernateInstructor.class).list();
            instructors.forEach(System.out::println);
            session.getTransaction().commit();
        }

        return instructors;
    }

    public void insert(HibernateInstructor instructor) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(instructor);
            session.getTransaction().commit();
        }
    }

    public void delete(HibernateInstructor instructor) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(instructor);
            session.getTransaction().commit();
        }
    }

    public HibernateInstructor getById(int id) {
        HibernateInstructor instructor = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            instructor = session.get(HibernateInstructor.class, id);
            session.getTransaction().commit();
        }
        return instructor;
    }

    public void updateEmail(HibernateInstructor instructor) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            instructor.setEmail("ahmed@gizasystems.com");
            session.update(instructor);
            session.getTransaction().commit();
        }
    }
}