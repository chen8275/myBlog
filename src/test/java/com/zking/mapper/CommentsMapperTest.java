package com.zking.mapper;

import com.alibaba.fastjson.JSON;
import com.zking.entity.Comments;
import com.zking.entity.CommentsExample;
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
 * @since 2019/7/17 10:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CommentsMapperTest {
    @Autowired
    CommentsMapper commentsMapper;
    @Test
    public void  test(){
        CommentsExample example = new CommentsExample();
        CommentsExample.Criteria criteria= example.createCriteria();
        criteria.andUsernameEqualTo("xuxu");
        List<Comments> comments = commentsMapper.selectByExample(example);
        log.info("得到:{}",JSON.toJSONString(comments));
    } 
}