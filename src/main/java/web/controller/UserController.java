package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("users", userService.allUsers());
        return "user/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/user/home";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(value = "id", required = false) Long id, Model model) {
        System.out.println(id);
        if ( id != null && userService.getUserById(id) != null ) {
            model.addAttribute("user", userService.getUserById(id));
            return "user/edit";
        }
        return "redirect:/user/home";
    }

    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable(value = "id", required = false) Long id, @ModelAttribute("user") User user) {
        System.out.println();
        user.setId(id);
        userService.update(user);
        return "redirect:/user/home";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.remove(user);
        return "redirect:/user/home";
    }



}


