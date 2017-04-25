package com.ecsolutions.controller;

import com.ecsolutions.entity.User_Entity;
import com.ecsolutions.service.User_Service;
import org.jasypt.encryption.StringEncryptor;
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

    private final String PROJECTNAME = "/CustomerSingleView";

    @Autowired
    StringEncryptor stringEncryptor;

    public User_Service getUser_service() {
        return user_service;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "next",required = false) Optional<String> next, Model model) {
        if (next.isPresent())
            model.addAttribute("next", next.get());
        model.addAttribute("projectname", PROJECTNAME);
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("next") String next, @RequestParam("userid") String userid, @RequestParam("password") String password, HttpSession session, Model model) {
        // Get User instance
//        User_Entity user = user_service.findUser(userid, password);
        User_Entity user = user_service.getUser(userid);

        if (user == null || !password.equals(stringEncryptor.decrypt(user.getPassword()))) {
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
        if (next != null && (adminflag.equals("Y") && next.startsWith("/admin"))) // || adminflag.equals("N") && next.startsWith("/user")
            return "redirect:".concat(next.trim());
        else {
            if (user.getAdminflag().equals("Y"))
                return "redirect:/admin";
            else
                return "redirect:/user";
//                return "/user";
        }
    }

    @GetMapping("/admin")
    public String adminPage(HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);

        model.addAttribute("projectname", PROJECTNAME);
        return "Admin/AdminMain";
    }


//    @GetMapping("/test")
//    public String testPage(Model model) {
//        User_Entity user = new User_Entity();
//        user.setUsername("111");
//        model.addAttribute("user",user);
//        return "test";
//    }


    @GetMapping("/user")
    public String userPage(HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        model.addAttribute("projectname", PROJECTNAME);
        return "User/UserMain";
    }

    @GetMapping("/user/singleView")
    public String singleViewPage(@RequestParam(value = "customer_code", required = false) String customer_code, HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        if (customer_code != null) {
            if (user_service.validateCustomer(customer_code.trim(), user.getUserid())) {
                model.addAttribute("customer_code", customer_code);
                model.addAttribute("projectname", PROJECTNAME);
                return "User/SingleView";
            }
        }
        return "redirect:/user";
    }

    @GetMapping("/admin/authorityManage")
    public String authorityManagePage(HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        model.addAttribute("projectname", PROJECTNAME);
        return "Admin/AuthorityManage";
    }

    @GetMapping("/admin/userManage")
    public String userManagePage(HttpServletRequest request, Model model) {
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        model.addAttribute("projectname", PROJECTNAME);
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
