package com.fw.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("picture")
public class PictureController {
    /**
     * 获取图片管理页面
     * */
    @GetMapping
    public String getPicture(){
        return "picture/picture-list";
    }

    /**
     * 获取添加图片页面
     * */
    @GetMapping(value = "/insert")
    public String getAddPicturePage(){
        return "picture/picture-add";
    }

    /**
     * 获取图片更新页面
     * */
    @GetMapping(value = "/update")
    public String getUpdatePicturePage(){
        return "picture/picture-show";
    }
}
