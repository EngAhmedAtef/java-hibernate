package hibernate.util;

import hibernate.entities.HibernateCourse;
import hibernate.entities.HibernateInstructor;
import hibernate.entities.HibernateInstructorDetails;
import hibernate.entities.HibernateStudent;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            config.addAnnotatedClass(HibernateInstructor.class);
            config.addAnnotatedClass(HibernateStudent.class);
            config.addAnnotatedClass(HibernateCourse.class);
            config.addAnnotatedClass(HibernateInstructorDetails.class);

            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(registry);
            System.out.println("Built the session factory");
        }
        return sessionFactory;
    }
}
