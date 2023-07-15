package com.schoolmanagement.controllers;

import com.schoolmanagement.bean.User;
import com.schoolmanagement.dao.UserDao;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tek
 */
@Controller
public class LoginController {
    private final UserDao userDao;

    public LoginController(UserDao userDao) {
        this.userDao = userDao;
    }
     @RequestMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        boolean login = userDao.validateUser(email,password);
        if (login ) {
            User user = userDao.getByEmail(email);
            session.setAttribute("loggedInUser", user);
            return "redirect:/";
        } else {
            // Invalid credentials
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}




