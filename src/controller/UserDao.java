package controller;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

public class UserDao {

	// create a new user account
    public String createAccount(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user); // Save the user object
            transaction.commit();
            session.close();
            return "User  account created successfully!";
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback(); // Rollback in case of an error
            }
            ex.printStackTrace();
            return "Error creating user account: " + ex.getMessage();
        }
    }

    //  retrieve a user by ID
    public User getUserById(UUID userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, userId); // Retrieve user by ID
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
