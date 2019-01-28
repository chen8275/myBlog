package com.zking.controller;

import com.zking.entity.Article;
import com.zking.entity.Categories;
import com.zking.entity.User;
import com.zking.mapper.UserMapper;
import com.zking.service.CategoriesService;
import com.zking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/front/*")
public class IndexController {
    
    Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Autowired
    UserService userService;
    
    @Autowired
    CategoriesService categoriesService;
    
    @Autowired
    UserMapper userMapper;
    
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
    public String user(Model model,HttpServletRequest request){
        String userName = request.getSession().getAttribute("userName").toString();
        User user = userMapper.getUserPersonalInfo(userName);
        model.addAttribute("user",user);
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
        User user = userService.selectByUsernameAndPassword(username,password);
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
            userService.insertSelective(user);
            return "index";
        }else {
            return "register";
        }
    }
    
    //进入写博客页
    @RequestMapping("/write")
    public String write(Model model, Article article){
        List<Categories> categories = categoriesService.list();
        model.addAttribute("categories",categories);
        model.addAttribute("article",new Article());
        return "write";
    }
    //进入友链页面
    @RequestMapping("/friendLink")
    public String write(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        model.addAttribute("userName",username);
        return "friendLink";
    }
    //进入关于我页面
    @RequestMapping("/aboutme")
    public String about(){
        return "aboutme";
    }
    
    //进入更新页面
    @RequestMapping("/update")
    public String update(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        model.addAttribute("userName",username);
        return "update";
    }
    
    //进入标签页面
    @RequestMapping("/tags")
    public String tags(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        model.addAttribute("userName",username);
        return "tags";
    }
    //进入分类页面
    @RequestMapping("/categories")
    public String categories(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        model.addAttribute("userName",username);
        return "categories";
    }
    //进入后台管理页面
    @RequestMapping("/admin")
    public String admin(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        model.addAttribute("userName",username);
        return "admin";
    }
    //进入404页面
    @RequestMapping("/404")
    public String four(){
        return "404";
    }
}
