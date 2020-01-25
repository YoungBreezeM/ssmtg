package com.fw.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    /**
     * 获取品牌管理页面
     * */
    @GetMapping("/brand")
    public String getBrandPage(){
        return "product/product-brand";
    }

    /**
     * 分类管理
     * */
    @GetMapping("category")
    public String getCategoryPage(){
        return "product/product-category";
    }

    /**
     * 添加分类管理
     * */
    @GetMapping("category/insert")
     public String getAddCategoryPage(){
        return "product/product-category-add";
    }
    /**
     * 产品管理
     * */
    @GetMapping
    public String getProductPage(){
        return "product/product-list";
    }

    /**
     * 添加产品
     * */
    @GetMapping("/insert")
    public String getAddProduct(){
        return "product/product-add";
    }
}
