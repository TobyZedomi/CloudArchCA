package movieSystem.persistence;

import movieSystem.business.User;

import java.util.ArrayList;


public interface UserDao {


    public int registerUser(User newUser);

    public User login(String username, String password);

    public User findUserByUsername(String username);




}
