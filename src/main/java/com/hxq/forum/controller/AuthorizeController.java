package com.hxq.forum.controller;

import com.hxq.forum.dto.AccessTokenDTO;
import com.hxq.forum.dto.GithubUser;
import com.hxq.forum.provider.GithubProvider;
import com.hxq.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.redirect.uri}")
    private String redirect_uri;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @GetMapping(value = "/callback")
    public String callback(@RequestParam(name = "code") String code,@RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        System.out.println("accessToken" + accessToken);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        if(null!=user){
            GithubUser queryUser = userService.queryUser(user);
            if(queryUser==null){
                int i = userService.insertUser(user);
            }
            return "access";
        }
        return "fail";
    }
}
