package com.JavaWebSerice.WebService.dao;

import com.JavaWebSerice.WebService.models.User;

import java.util.List;
/*The interface indicates how the function should be. The class that
implements said interface is obligated to build that function
 */
public interface UserDao {
    List<User> listUsers();

    void delete(long id);

    void register(User user);

    boolean verifyCredentials(User user);
}
