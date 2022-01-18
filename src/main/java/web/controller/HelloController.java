package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAO;
import web.models.User;

import javax.validation.Valid;


@Controller
@RequestMapping()
public class HelloController {

    private final UserDAO userDAO;

    @Autowired
    public HelloController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @GetMapping("/user")
    public String index(Model model) {
        model.addAttribute("people", userDAO.index());
        return "user";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("person", userDAO.getById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userDAO.save(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("person", userDAO.getById(id));
        return "/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id) {
        if (bindingResult.hasErrors())
            return "/edit";
        userDAO.update(user);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userDAO.delete(userDAO.getById(id));
        return "redirect:/user";
    }
}
