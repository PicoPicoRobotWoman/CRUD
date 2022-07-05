package web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.Service.UserService;
import web.Service.UserServiceImpl;
import web.model.User;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String page(Model model) {
        model.addAttribute( "users" ,userService.allUsers());
        model.addAttribute("user", new User());

        return "/user/users";
    }

    @PostMapping
    public String AddUser(@ModelAttribute(value = "user") User user) {
        System.out.println("add");
        if (user.getName() != null && user.getAge() != null) {
            userService.add(user);
        }
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        System.out.println("delete");
        userService.delete(userService.getUserById(id));

        return "redirect:/users";
    }

}


