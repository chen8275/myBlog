package com.zking.controller;

import com.zking.dao.UserDao;
import com.zking.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String users(Model model){
        List<UserEntity> list = userDao.findAll();
        model.addAttribute("users",list);
        return "user";
    }
    
    //增加用户
    @RequestMapping("/toAdd")
    public String add(){
        return "add";
    }
    @RequestMapping("/add")
    public String add(UserEntity user) {
        userDao.save(user);
        return "redirect:/front/listUsers";
    }
    //删除用户
    @RequestMapping("/delete")
    public String delete(long id){
        userDao.delete(id);
        return "redirect:/front/listUsers";
    }
    //编辑用户
    @RequestMapping("/toEdit")
    public String edit(Model model,long id){
        UserEntity userEntity = userDao.findUserEntityById(id);
        model.addAttribute("user",userEntity);
        return "edit";
    }
    @RequestMapping("/edit")
    public String editUser(UserEntity user){
        userDao.save(user);
        return "redirect:/front/listUsers";
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
