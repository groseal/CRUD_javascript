package groseal.controllers;

import groseal.models.Role;
import groseal.models.User;
import groseal.service.RoleService;
import groseal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class RestAdminController {
    private RoleService roleService;
    private UserService userService;

    @Autowired
    public RestAdminController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    //Создание нового пользователя
    @PostMapping(value = "/admin/new")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Получение всех пользователей
    @GetMapping(value = "/all_users")
    public ResponseEntity<List<User>> findAll() {
        final List<User> users = userService.getAllUser();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/all_roles")
    public ResponseEntity<List<Role>> findAllRole() {
        final List<Role> users = roleService.getAllRoles();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Получение пользователя по ID
    @GetMapping(value = "/user/{id)")
    public ResponseEntity<User> read(@PathVariable(name = "id") Long id) {
        final User user = userService.readUser(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Получение пользователя по имени
    @GetMapping(value = "/user/{name)")
    public ResponseEntity<User> search(@PathVariable(name = "name") String name) {
        User user = userService.searchUser(name);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Обновление позьзователя
    @PutMapping(value = "/admin/edit/{id}")
    public ResponseEntity<User> update(@PathVariable(name = "id") Long id,
                                    @RequestBody User user) {
        final boolean updated = userService.updateUser(user);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Удаление пользователя
    @DeleteMapping(value = "/admin/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = userService.deleteUser(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }


}
