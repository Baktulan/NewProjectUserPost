package services;

import models.User;

import java.util.List;

public interface UserService {

    String register(User user);
    String login(String login,String password);
    User getUserByEmail(String email);
    List<User>getAllUsers();


}
