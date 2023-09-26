package hibernate.util;

import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import hibernate.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            config.addAnnotatedClass(Instructor.class);
            config.addAnnotatedClass(Student.class);
            config.addAnnotatedClass(Course.class);
            config.addAnnotatedClass(InstructorDetails.class);

            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(registry);
            System.out.println("Built the session factory");
        }
        return sessionFactory;
    }

    public static void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("Closed session factory");
        }
    }
}
