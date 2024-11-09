package util;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import model.*;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Set Hibernate properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/testing");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "jere24");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create");
                
                
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.USE_SQL_COMMENTS, "true");
                settings.put(Environment.GENERATE_STATISTICS, "true");

                settings.put(Environment.C3P0_MIN_SIZE, 5);           
                settings.put(Environment.C3P0_MAX_SIZE, 20);           
                settings.put(Environment.C3P0_ACQUIRE_INCREMENT, 1);   
                settings.put(Environment.C3P0_TIMEOUT, 1800);          
                settings.put(Environment.C3P0_MAX_STATEMENTS, 150);
               

                configuration.setProperties(settings);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                
                // Register entity classes
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Membership.class);
                configuration.addAnnotatedClass(Location.class);
                configuration.addAnnotatedClass(MembershipType.class);
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Shelf.class);
                configuration.addAnnotatedClass(Room.class);
                configuration.addAnnotatedClass(Borrower.class);

               

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        }
        return sessionFactory;
    }
}
