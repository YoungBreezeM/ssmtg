package com.fw.service.impl;

import com.fw.dao.SpaceDao;
import com.fw.domain.Space;
import com.fw.service.SpaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("spaceService")
public class SpaceServiceImpl implements SpaceService {
    @Resource(name = "spaceDao")
    private SpaceDao spaceDao;

    @Override
    public List<Space> findAll() {
        return spaceDao.findAll();
    }

    @Override
    public List<Space> findAllSpace() {
        return spaceDao.findAllSpace();
    }

    @Override
    public Space findAllBySpaceName(String spaceName) {
        List<Space> spaces = spaceDao.findAllBySpaceName(spaceName);
        if(spaces.isEmpty()){
            return null;
        }
        if(spaces.size()>1){
            throw new RuntimeException("空间数据名字不唯一，请及时修改");
        }
        return spaces.get(0);
    }

    @Override
    public Space findById(Integer sid) {
        List<Space> spaces = spaceDao.findById(sid);
        if(spaces.isEmpty()){
            return null;
        }
        if (spaces.size()>1){
            throw new RuntimeException("数据库出错");
        }
        return spaces.get(0);
    }

    @Override
    public Boolean isReSpaceName(String spaceName) {
        List<Space> spaces = spaceDao.findBySpaceName(spaceName);
        return spaces.size() > 0;
    }

    @Override
    public void addSpace(Space space) {
        spaceDao.addSpace(space);
    }

    @Override
    public void updateSpace(Space space) {
        spaceDao.updateSpace(space);
    }

    @Override
    public void deleteSpace(Integer sid) {
        spaceDao.deleteSpace(sid);
    }
}
