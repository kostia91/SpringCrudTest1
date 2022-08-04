package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    //ставить конструктор final-это правило хорошего тона
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Model - это почти как мапа в Java
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        //мы взяли всех юзеров из бд и запихнули их в юзерс
        model.addAttribute("users", users);
        //users в кавычках это то, к чему привязывает в html

        return "user-list"; //переход в html где вся логика
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")//прошу заметить, что адреса одинакове
    //тоже самое, но уже пост запрос
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    //в фигурных скобках передается переменная
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}