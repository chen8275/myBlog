package com.zking.controller;

import com.zking.mapper.UserMapper;
import com.zking.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/front/*")
public class IndexController {
    
    Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserMapper userMapper;

    //index页面
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //注册页面
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    //登陆页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    //个人中心
    @RequestMapping("/user")
    public String user(){
        return "user";
    }
    
    //进入主页
    @RequestMapping("/show")
    public String moveShow(){
        return "show";
    }
    //登出
    @RequestMapping("/logout")
    public String moveOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userName","false");
        return "show";
    }
    //登陆方法
    @RequestMapping("/loginPage")
    public String loginPage(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("userName",username);
        User user = userMapper.findByUsernameAndPassword(username,password);
        logger.info(user.getUsername());
        if (user !=null){
            return "show";
        }else {
            return "login";
        }
    }
    //注册方法
    @RequestMapping("/addregister")
    public String register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (password.equals(password2)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userMapper.save(user);
            return "index";
        }else {
            return "register";
        }
    }
    //personData
    @RequestMapping("personData")
    public String personData(Model model){
        model.addAttribute("personData","personData");
        return "user";
    }

}
