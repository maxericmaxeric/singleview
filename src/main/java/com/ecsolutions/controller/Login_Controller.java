package com.ecsolutions.controller;

import com.ecsolutions.entity.User_Entity;
import com.ecsolutions.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by Administrator on 2017/4/1.
 */
@Controller
public class Login_Controller {
    @Autowired
    private User_Service user_service;

    public User_Service getUser_service() {
        return user_service;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam("next") Optional<String> next) {
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("next") Optional<String> next, @RequestParam("userid") String userid, @RequestParam("password") String password, HttpSession session, Model model) {
        // Get User instance
        User_Entity user = user_service.findUser(userid, password);
        if (user == null) {
            session.setAttribute("MESSAGE", "userid/password invalid!");
            model.addAttribute("MESSAGE", "userid/password invalid!");
            return "login";
        } else if (user.getStatus().equals("D")) {
            session.setAttribute("MESSAGE", "This user has been deactivated, please contact the administrator!");
            model.addAttribute("MESSAGE", "This user has been deactivated, please contact the administrator!");
            return "login";
        } else if (user.getStatus().equals("C")) {
            session.setAttribute("MESSAGE", "This user has been cancelled, please contact the administrator!");
            model.addAttribute("MESSAGE", "This user has been cancelled, please contact the administrator!");
            return "login";
        }
        session.setAttribute("CURRENT_USER", user);
        String adminflag = user.getAdminflag();
        if (next.isPresent() && (adminflag.equals("Y") && next.get().startsWith("/admin") || adminflag.equals("N") && next.get().startsWith("/user")))
            return "redirect:".concat(String.valueOf(next));
        else {
            if (user.getAdminflag().equals("Y"))
                return "redirect:".concat("/admin");
            else
                return "redirect:".concat("/user");
        }
    }

    @GetMapping("/admin")
    public String adminPage(HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        return "Admin/AdminMain";
    }


    @GetMapping("/test")
    public String testPage(Model model) {
        User_Entity user = new User_Entity();
        user.setUsername("111");
        model.addAttribute("user",user);
        return "test";
    }


    @GetMapping("/user")
    public String userPage(HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        return "User/UserMain";
    }

    @GetMapping("/user/singleView")
    public String singleViewPage(HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        return "User/SingleView";
    }

    @GetMapping("/admin/authorityManage")
    public String authorityManagePage(HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        return "Admin/AuthorityManage";
    }

    @GetMapping("/admin/userManage")
    public String userManagePage(HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        return "Admin/UserManage";
    }

    @GetMapping("/logout")
    public String userManagePage(HttpServletRequest request) {
        try {
            request.getSession().removeAttribute("CURRENT_USER");
        } catch (Exception ex) {

        }
        return "redirect:".concat("/login");
    }
}
