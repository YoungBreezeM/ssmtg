package com.fw.service;

import com.fw.domain.User;

public interface LoginService {
    /**
     * 验证用户信息
     * */
     User checkInfo(User user);
}
