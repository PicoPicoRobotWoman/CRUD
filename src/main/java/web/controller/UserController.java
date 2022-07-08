package web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("create")
    public String createPage(Model model) {
        model.addAttribute( "users" ,userService.allUsers());
        model.addAttribute("user", new User());

        return "user/create";
    }

    @PostMapping("create")
    public String createUser(@ModelAttribute(value = "user") User user) {
        if (user.getName() != null && user.getAge() != null) {
            userService.create(user);
        }
        return "redirect:/create";
    }

    @GetMapping("select")
    public String editPage(Model model) {
        model.addAttribute( "users" ,userService.allUsers());
        return "user/select";
    }

    @PostMapping("select")
    public String editUser(@RequestParam(value = "id", required = false) Long id) {
        if (userService.getUserById(id) != null) {
            return "redirect:/select/" + id;
        }
        return "redirect:/select";
    }

    @GetMapping("select/{id}")
    public String UpdatePage(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));

        return "user/edit";
    }

    @PatchMapping("select/{id}/update")
    public String UpdateUser(@ModelAttribute("user") User user) {
        userService.update(user);

        return "redirect:/select";
    }

    @DeleteMapping("select/{id}/remove")
    public String removeUser(@ModelAttribute("user") User user) {
        userService.remove(user);

        return "redirect:/select";
    }



}


