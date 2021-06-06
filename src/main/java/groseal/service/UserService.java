package groseal.service;

import groseal.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User createUser(User user);

    User readUser(Long id);

    boolean updateUser(User user);

    boolean deleteUser(Long id);

    List<User> getAllUser();

    public User searchUser(String name);

}
