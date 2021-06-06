package groseal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String findAll() {
        return "allUsers";
    }


//    //Показывает всех юзеров из БД
//    @GetMapping
//    public String findAll(Model model, Principal principal) {
//        User user = (User) userService.loadUserByUsername(principal.getName());
//        model.addAttribute("users", userService.getAllUser());
//        model.addAttribute("roles", roleService.getAllRoles());
//        model.addAttribute("new_user", new User());
//        model.addAttribute("user", user);
//        return "allUsers";
//    }
//
//    //Создает форму для создания юзера
//    @GetMapping("/new")
//    public String newUser(ModelMap model) {
//        model.addAttribute("user", new User());
//        return "newUser";
//    }
//
//    //Получает данные из формы и создает юзера
//    @PostMapping("/addUser")
//    public String createUser(@ModelAttribute("new_user") User user) {
//        mappingRoles(user);
//        userService.createUser(user);
//        return "redirect:/admin";
//    }
//
//    //Создает форму для редактирования юзера
//    @GetMapping("/edit/{id}")
//    public String editUser(Model model, @PathVariable(value = "id") Long id) {
//        model.addAttribute("user", userService.readUser(id));
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "/editUser";
//    }
//
//    //Получает данные из формы и обновляет данные юзера
//    @PatchMapping(path = "/edit/{id}")
//    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.PATCH, RequestMethod.POST})
//    public String updateUser(@ModelAttribute("user") User user) {
//        mappingRoles(user);
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//
//    //Удаление юзера
//    @PostMapping({"/delete{id}"})
////    @DeleteMapping({"/delete{id}"})
//    public String deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }
//
//    private void mappingRoles(@ModelAttribute("new_user") User user) {
//        Set<Role> roles = new HashSet<>();
//        for (Role r : roleService.getAllRoles()) {
//            if (user.getUserRoles().toString().contains(r.getRole())) {
//                roles.add(roleService.getRoleByName(r.getRole()));
//            }
//        }
//        user.setUserRoles(roles);
//    }
}
