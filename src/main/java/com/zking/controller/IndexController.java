package com.zking.controller;

import com.zking.entity.Article;
import com.zking.entity.Categories;
import com.zking.entity.User;
import com.zking.mapper.UserMapper;
import com.zking.service.ArticleService;
import com.zking.service.CategoriesService;
import com.zking.service.UserService;
import com.zking.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tautua.markdownpapers.Markdown;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
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
    ArticleService articleService;
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
    //判断是不是登陆状态，不是返回0
    @RequestMapping("isLogin")
    public int isLogin(HttpServletRequest request){
        String userName = request.getSession().getAttribute("userName").toString();
        if ("".equals(userName)||userName == "false"){
            return 0;
        }else 
            {
                return 1;
            }
    }
    //登陆页面
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userName","false");
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
    public String moveShow(Model model){
        List<Article> articles = articleService.listArticles();
        model.addAttribute("articles",articles);
        return "show";
    }
    //登出
    @RequestMapping("/logout")
    public String moveOut(HttpServletRequest request,Model model){
        List<Article> articles = articleService.listArticles();
        model.addAttribute("articles",articles);
        HttpSession session = request.getSession();
        session.setAttribute("userName","false");
        return "show";
    }
    //登陆方法
    @RequestMapping("/loginPage")
    public String loginPage(HttpServletRequest request,Model model){
        List<Article> articles = articleService.listArticles();
        model.addAttribute("articles",articles);
        
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
    
    //发布文章
    @RequestMapping("/saveArticle")
    public String save(Article article,HttpServletRequest request){
        String username = request.getSession().getAttribute("userName").toString(); 
        article.setAuthor(username);
        TimeUtil timeUtil = new TimeUtil();
        String nowDate = timeUtil.getFormatDateForThree();
        article.setPublishdate(nowDate);
        article.setUpdatedate(nowDate);
        //设置摘要,取前40个字
        if(article.getArticlecontent().length() > 200){
            article.setArticletabloid(article.getArticlecontent().substring(0, 200));
        }else {
            article.setArticletabloid(article.getArticlecontent().substring(0, article.getArticlecontent().length()));
        }
        articleService.insert(article);
        return "publishSuccess";
    }
    
    //进入文章详情页
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        Article article = articleService.getById(id);
        Markdown markdown = new Markdown();
        try {
            StringWriter out = new StringWriter();
            markdown.transform(new StringReader(article.getArticlecontent()), out);
            out.flush();
            article.setArticlecontent(out.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("article", article);
        return "detail";
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
