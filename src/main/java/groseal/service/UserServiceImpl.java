package groseal.service;

import groseal.dao.UserDAO;
import groseal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        userDAO.createUser(user);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User readUser(Long id) {
        return userDAO.readUser(id);
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        userDAO.updateUser(user);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteUser(Long id) {
        userDAO.deleteUser(id);
        return true;
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDAO.getUserByName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User " + username + " not found");
//        }
//        return new org.springframework.security.core.userdetails.User(
//                user.getName(), user.getPassword(), mapRolesToAuthorities(user.getUserRoles())
//        );
        return userDAO.loadUserByUsername(username);
    }

    @Override
    public User searchUser(String name){
        return userDAO.searchUser(name);
    }

    //делает из ролей пользователя GrantedAuthority для метода loadUserByUsername
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
//    }
}
