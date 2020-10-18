package com.controller;

import com.domain.Account;
import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.PublicKey;

@Controller
@RequestMapping("param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username, String password){
        System.out.println("执行了......");
        System.out.println("用户名: " + username);
        System.out.println("密码: " + password);
        return "success";
    }

    /**
     * 把数据封装到javaBean的类中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了......");
        System.out.println(account.toString());
        return "success";
    }

    /**
     * 自定义类型转化器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("执行了......");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了。。。。");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }
}
