package com.fw.service;

import com.fw.domain.Space;

import java.util.List;

public interface SpaceService {
    /**
     * 查找所有
     * */
    List<Space> findAll();
    /**
     * 查找所有系统可用空间
     *
     * */
    List<Space> findAllSpace();

    /**
     * 通过空间名查找
     * */
    Space findAllBySpaceName(String spaceName);

    /**
     * 通过id查找
     * */
    Space findById(Integer sid);

    /**
     * 判断空间名是否重复
     * */
    Boolean isReSpaceName(String spaceName);

    /**
     * 增加信息
     * */
    void addSpace(Space space);

    /**
     * 更新信息
     * */

    void updateSpace(Space space);

    /**
     * 删除信息
     * */
    void deleteSpace(Integer sid);
}
