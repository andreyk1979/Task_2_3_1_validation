package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showAllUsersList(Model model) {
        model.addAttribute("people", userService.getUsersFromList());
        return "user";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("personID", userService.getById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") User user) {
        return "new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("person") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("person", userService.getById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id) {
        if (bindingResult.hasErrors())
            return "/edit";
        userService.update(user);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/user";
    }
}
