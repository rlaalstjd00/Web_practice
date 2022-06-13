package com.example.FrontControllerEx.web.frontController.controller.V1;

import com.example.FrontControllerEx.domain.user.User;
import com.example.FrontControllerEx.domain.user.UserRepository;
import com.example.FrontControllerEx.web.frontController.ModelView;

import java.util.Map;

public class UserSaveControllerV1 implements ControllerV1 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String userid = paramMap.get("userid");
        String userpw = paramMap.get("uesrpw");
        String username = paramMap.get("username");
        int userage = Integer.parseInt(paramMap.get("userage"));

        User user = new User(userid, userpw, username, userage);
        userRepository.save(user);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("user", user);
        return modelView;
    }
}
