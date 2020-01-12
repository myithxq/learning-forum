package com.hxq.forum.provider;

import com.alibaba.fastjson.JSON;
import com.hxq.forum.dto.AccessTokenDTO;
import com.hxq.forum.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

    /**
     * 调用Github API 获取 token
     * @param accessTokenDTO
     * @return token
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSON(accessTokenDTO).toString());
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String access_token = string.split("&")[0].split("=")[1];
            return access_token;
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * 通过token 获取到用户信息
     * @param access_token
     * @return GithubUser
     */
    public GithubUser getUser(String access_token){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+access_token)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }

}
