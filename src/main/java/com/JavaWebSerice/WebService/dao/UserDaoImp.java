package com.JavaWebSerice.WebService.dao;

import com.JavaWebSerice.WebService.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
    public User obtainUserForCredentials(User user) {
        /*
        password decoder. we won't verify password against db
        See how to handle it with try-catch
         */

        String query = "FROM User WHERE email = :email";
        List<User> list= entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        if (list.isEmpty()){
            System.out.println("null line list.isEmpty userDaoImp");
            return null;
        }

        String passwordHashed = list.get(0).getPassword();
        char[] password = user.getPassword().toCharArray();

        Argon2 passVerify = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(passVerify.verify(passwordHashed, password)) {
            System.out.println("user object: " + list.get(0));
            return list.get(0);
        }
        return null;
    }
    /*
    String query = "FROM User WHERE email = 'user.getEmail' AND password = '' ";
    can lead to SQL Injection.
    We want it to return a boolean to know if credentials are valid.
     */
}
