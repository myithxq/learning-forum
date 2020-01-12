package com.hxq.forum.services;

import com.hxq.forum.dto.GithubUser;
import org.springframework.stereotype.Service;

public interface UserService {
    int insertUser(GithubUser user);

    int updateUser(GithubUser user);

    GithubUser queryUser(GithubUser user);

    int deleteUser(String user_id);
}
