package com.JavaWebSerice.WebService.dao;

import com.JavaWebSerice.WebService.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }
    /*
    the class User must say to which table the query must go
    as this query references our class User
     */

    @Override
    public boolean verifyCredentials(User user) {
        String query = "FROM User WHERE email = :email AND password = :password ";
        List<User> list= entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();

        return !list.isEmpty();

    }
    /*
    String query = "FROM User WHERE email = 'user.getEmail' AND password = '' ";
    can lead to SQL Injection.
    We want it to return a boolean to know if credentials are valid.
     */
}
