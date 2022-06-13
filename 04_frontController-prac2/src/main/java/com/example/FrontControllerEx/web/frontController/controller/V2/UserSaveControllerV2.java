package com.example.FrontControllerEx.web.frontController.controller.V2;

import com.example.FrontControllerEx.domain.user.User;
import com.example.FrontControllerEx.domain.user.UserRepository;

import java.util.Map;

public class UserSaveControllerV2 implements ControllerV2 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String userid = paramMap.get("userid");
        String userpw = paramMap.get("userpw");
        String username = paramMap.get("username");
        int userage = Integer.parseInt(paramMap.get("userage"));

        User user = new User(userid, username, userpw, userage);
        userRepository.save(user);

        model.put("user", user);

        return "save-result";
    }
}

