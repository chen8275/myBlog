package com.zking.controller;

import com.zking.dao.UserDao;
import com.zking.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/12.
 */

@Controller
@RequestMapping("/front/*")
public class IndexController {
    
    Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserDao userDao;

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
    //查看用户页面
    @RequestMapping("/listUsers")
    public String users(){
        return "user";
    }
    //登陆方法
    @RequestMapping("/loginPage")
    public String loginPage(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("userName",username);
        UserEntity userEntity = userDao.findByUsernameAndPassword(username,password);
        logger.info(userEntity.getUsername());
        if (userEntity!=null){
            return "hello";
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
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userDao.save(userEntity);
            return "index";
        }else {
            return "register";
        }
    }

}
