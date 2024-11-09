package controller;

import model.Location;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LocationDAO {

    // Save a new location
    public static void saveLocation(Location location) {
    	 Session session = null;
    	    Transaction transaction = null;
    	    try {
    	        session = HibernateUtil.getSessionFactory().openSession(); // Get a new session
    	        transaction = session.beginTransaction(); // Begin transaction

    	       // session.save(location); // Save the location
                session.persist(location);
    	        transaction.commit(); // Commit transaction
    	    } catch (Exception e) {
    	        if (transaction != null) transaction.rollback(); // Rollback on exception
    	        e.printStackTrace();
    	    } finally {
    	        if (session != null) session.close(); // Ensure session is closed
    	    }

    }

    public static Location getLocationByCode(String locationCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Location WHERE locationCode = :locationCode", Location.class)
                    .setParameter("locationCode", locationCode)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Location> getAllLocations() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Location", Location.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
