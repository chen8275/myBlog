package com.zking.service.impl;

import com.zking.entity.Article;
import com.zking.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chendesheng chendesheng@tuhu.cn
 * @since 2019/4/10 10:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ArticleServiceImplTest {
    @Autowired
    ArticleService articleService;
    @Test
    public void listAllArticles() {
        int pageNum = 1;
        int pageSize = 2;
        List<Article> articles = articleService.listAllArticles(pageNum,pageSize);
        log.info("articles:"+articles);
    }
}