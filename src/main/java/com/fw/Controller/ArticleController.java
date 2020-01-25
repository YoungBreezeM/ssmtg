package com.fw.Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/article")
public class ArticleController {
    /**
     * 获取文章列表
     * */
    @GetMapping
    public String getArticle(){
        return "article/article-list";
    }

    /**
     * 获取添加信息页面
     * */
    @GetMapping(value = "/insert")
    public String getAddArticlePage(){
        return "article/article-add";
    }

    /**
     * 获取文章分类信息
     * */
    @GetMapping(value = "/class")
    public String getClassArticle(){
        return "article/article-class";
    }

    /**
     * 获取分类编辑页面
     * */
    @GetMapping(value = "/class/insert")
    public String getClassInsertPage(){
        return "article/article-class-edit";
    }

}
