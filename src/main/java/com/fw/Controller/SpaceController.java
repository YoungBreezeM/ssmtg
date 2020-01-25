package com.fw.Controller;

import com.fw.domain.Result;
import com.fw.domain.Space;
import com.fw.service.SpaceService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "space")
public class SpaceController {
    @Resource(name = "spaceService")
    private SpaceService spaceService;

    @Resource(name = "result")
    private Result result;

    /**
     * 获取所有数据
     * */
    @GetMapping
    public ModelAndView getAllSpace(){
        List<Space> spaces = spaceService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("spaces",spaces);
        mv.setViewName("admin/permission/admin-permission");
        return mv;
    }

    /**
     * 添加空间页面获取
     * */
    @GetMapping(value = "insert")
    public ModelAndView getAddPage(){
        List<Space> spaces = spaceService.findAllSpace();
        ModelAndView mv = new ModelAndView();
        mv.addObject("spaces",spaces);
        mv.setViewName("admin/permission/admin-permission-add");
        return mv;
    }

    /**
     * 添加空间
     * */
    @PostMapping(value = "insert")
    public ModelAndView addSpace(Space space){
        System.out.println(space);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/permission/admin-permission-add");
        //判断空间名字是否存在
        if(spaceService.isReSpaceName(space.getSpaceName())){
            result.setCode(1);
            result.setMessage("空间名已经存在");
            mv.addObject("result",result);
            return mv;
        }
        Space space1 = spaceService.findAllBySpaceName(space.getSpaceName());
        space.setPath(space1.getPath());
        spaceService.addSpace(space);
        result.setCode(0);
        result.setMessage("success");
        mv.addObject("result",result);
        return mv;
    }

    /**
     * 获取更新空间信息
     * */
    @GetMapping(value = "/update/{sid}")
    public ModelAndView getUpdatePage(@PathVariable Integer sid){
        Space space = spaceService.findById(sid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("space",space);
        mv.setViewName("admin/permission/admin-permission-update");
        return mv;
    }

    /**
     * 更新信息
     * */
    @PostMapping(value = "/update")
    public ModelAndView updateSpace(Space space){
        Space space1 = spaceService.findAllBySpaceName(space.getSpaceName());
        space.setPath(space1.getPath());
        spaceService.updateSpace(space);
        ModelAndView mv = new ModelAndView();
        result.setCode(0);
        result.setMessage("success");
        mv.addObject("result",result);
        mv.setViewName("admin/permission/admin-permission-update");
        return mv;
    }

    /**
     * 删除信息
     * */
    @GetMapping(value = "/delete/{sid}")
    public String deleteSpace(@PathVariable Integer sid){
        spaceService.deleteSpace(sid);
        return "success";
    }

}
