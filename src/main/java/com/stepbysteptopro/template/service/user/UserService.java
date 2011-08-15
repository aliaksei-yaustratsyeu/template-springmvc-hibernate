/**
 * 
 */
package com.stepbysteptopro.template.service.user;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.stepbysteptopro.template.dao.user.UserDao;
import com.stepbysteptopro.template.exception.UserExistsException;
import com.stepbysteptopro.template.model.user.User;


/**
 * @author AYaustratsyeu
 * 
 */
public interface UserService {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param userDao the UserDao implementation to use
     */
    void setUserDao(UserDao userDao);

    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param userId the identifier for the user
     * @return User
     */
    User getUser(String userId);

    /**
     * Finds a user by their username.
     * @param username the user's username used to login
     * @return User a populated user object
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *         exception thrown when user not found
     */
    User getUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<User> getUsers();

    /**
     * Saves a user's information.
     *
     * @param user the user's information
     * @throws UserExistsException thrown when user already exists
     * @return user the updated user object
     */
    User saveUser(User user) throws UserExistsException;

    /**
     * Removes a user from the database by their userId
     *
     * @param userId the user's id
     */
    void removeUser(String userId);
    
    /**
     * Change password of user.
     * 
     * @param username The user name
     * @param password The user password
     */
    public void changePassword(String username, String password) throws UserExistsException;
}
