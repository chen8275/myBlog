package com.zking.controller;

import com.zking.entity.Article;
import com.zking.entity.Categories;
import com.zking.entity.User;
import com.zking.mapper.UserMapper;
import com.zking.service.ArticleService;
import com.zking.service.CategoriesService;
import com.zking.service.TagService;
import com.zking.service.UserService;
import com.zking.util.TimeUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tautua.markdownpapers.Markdown;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Random;
import java.util.UUID;


/**
 * @author chendesheng
 */
@Api(value = "后台操作",description = "详细描述")
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
    @Autowired
    TagService tagService;
    
    
    
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    /**
     * 进入index首页
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    /**
     * 进入注册页面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    /**
     * 判断是不是登陆状态
     * @return 是返回1，不是返回0
     */
    @GetMapping("isLogin")
    public int isLogin(HttpServletRequest request){
        String userName = request.getSession().getAttribute("userName").toString();
        if ("".equals(userName)||userName == "false"){
            return 0;
        }else 
            {
                return 1;
            }
    }
    /**
     * 进入登陆页面
     * @return 
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userName","false");
        return "login";
    }
    /**
     * 进入个人中心页面
     * @return
     */
    @GetMapping("/user")
    public String user(Model model,HttpServletRequest request){
        String userName = request.getSession().getAttribute("userName").toString();
        User user = userMapper.getUserPersonalInfo(userName);
        model.addAttribute("user",user);
        return "user";
    }
    /**
     * 进入博客首页
     * @return
     */
    @GetMapping("/show")
    public String moveShow(Model model){
        List<Article> articles = articleService.listArticles();
        model.addAttribute("articles",articles);
        return "show";
    }
    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    public String moveOut(HttpServletRequest request,Model model){
        List<Article> articles = articleService.listArticles();
        model.addAttribute("articles",articles);
        HttpSession session = request.getSession();
        session.setAttribute("userName","false");
        return "show";
    }
    /**
     * 登陆
     * @return
     */
    @PostMapping("/loginPage")
    public String loginPage(HttpServletRequest request,Model model){
        List<Article> articles = articleService.listArticles();
        model.addAttribute("articles",articles);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("userName",username);
        User user = userService.selectByUsernameAndPassword(username,password);
        logger.info(user.getUsername());
        if (user != null){
            return "show";
        }else {
            return "login";
        }
    }
    /**
     * 注册
     * @return
     */
    @PostMapping("/addregister")
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
    
    /**
     * 进入写博客页
     * @param model
     * @return
     */
    @GetMapping("/editor")
    public String editor(Model model){
        List<Categories> categories = categoriesService.list();
        model.addAttribute("categories",categories);
        model.addAttribute("article",new Article());
        return "editor";
        
    }
    
    /**
     * 进入修改博客页面
     * @return
     */
    @PostMapping("/write")
    public String write(Model model,HttpServletRequest request){
        List<Categories> categories = categoriesService.list();
        String id = request.getParameter("id");
        if(!"".equals(id)){
            request.getSession().setAttribute("id", id);
        }
        Article article = articleService.getById(Integer.valueOf(id));
        model.addAttribute("articleBefore",article);
        model.addAttribute("categories",categories);
        model.addAttribute("article",new Article());
        
        return "write";
    }
    /**
     * 进入文章编辑页面
     * @return
     */
    @GetMapping("/writeUpdate/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        Article article = articleService.getById(id);
        List<Categories> categories = categoriesService.list();
        
        model.addAttribute("target", article);
        model.addAttribute("categories", categories);
        model.addAttribute("article", new Article());
    
        return "writeUpdate";
    }
    /**
     * 发布文章
     * @return
     */
    @PostMapping("/saveArticle")
    public String save(Article article,HttpServletRequest request){
        String username = request.getSession().getAttribute("userName").toString();
        long min = 1;
        long max = 10;
        long rangeLong = min + (((long) (new Random().nextDouble() * (max - min))));
        
        article.setArticleid(rangeLong);
        article.setOriginalauthor(username);
        article.setAuthor(username);
        TimeUtil timeUtil = new TimeUtil();
        String nowDate = timeUtil.getFormatDateForThree();
        //插入标签
        String tagName = article.getArticletags();
        int tagSize = (int)(Math.random() * 5 + 1);
        tagService.addTags(tagName,tagSize);
        //插入分类
        String categoryName = article.getArticlecategories();
        Categories categories = new Categories();
        categories.setCategoryname(categoryName);
        categoriesService.insertCategories(categories);
        
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
    /**
     * 进入文章详情页
     * @return
     */
    @GetMapping("/detail/{id}")
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
    /**
     * 进入友链页面
     * @return
     */
    @GetMapping("/friendLink")
    public String friendLink(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        if (!StringUtils.isEmpty(username)){
            model.addAttribute("userName",username);
        }        
        return "friendLink";
    }
    /**
     * 进入关于我页面
     * @return
     */
    @GetMapping("/aboutme")
    public String about(){
        return "aboutme";
    }
    
    /**
     * 进入更新页面
     * @return
     */
    @GetMapping("/update")
    public String update(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        if (!StringUtils.isEmpty(username)){
            model.addAttribute("userName",username);
        }
        return "update";
    }
    /**
     * 进入标签页面
     * @return
     */
    @GetMapping("/tags")
    public String tags(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        if(username!=null&&!"".equals(username)){
            model.addAttribute("userName",username);
        }
        return "tags";
    }
    /**
     * 进入分类页面
     * @return
     */
    @GetMapping("/categories")
    public String categories(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        if (!StringUtils.isEmpty(username)){
            model.addAttribute("userName",username);
        }
        return "categories";
    }
    /**
     * 进入后台管理页面
     * @return
     */
    @GetMapping("/superadmin")
    public String superadmin(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        model.addAttribute("userName",username);
        return "superadmin";
    }
    /**
     * 进入404
     * @return
     */
    @GetMapping("/404")
    public String four(){
        return "404";
    }
}
