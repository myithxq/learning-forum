package com.hxq.forum.services.impl;

import com.hxq.forum.dao.UserMapper;
import com.hxq.forum.dto.GithubUser;
import com.hxq.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(GithubUser user) {
        int i = userMapper.insertUser(user);
        return i;
    }

    @Override
    public int updateUser(GithubUser user) {
        return 0;
    }

    @Override
    public GithubUser queryUser(GithubUser user) {
        return null;
    }

    @Override
    public int deleteUser(String user_id) {
        return 0;
    }
}
