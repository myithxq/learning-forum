package com.hxq.forum.dao;

import com.hxq.forum.dto.GithubUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;
@Mapper
public interface UserMapper {
    int insertUser(GithubUser user);

    int updateUser(GithubUser user);

    GithubUser queryUser(GithubUser user);

    int deleteUser(String user_id);
}
