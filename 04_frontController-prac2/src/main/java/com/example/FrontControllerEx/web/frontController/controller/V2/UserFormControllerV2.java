package com.example.FrontControllerEx.web.frontController.controller.V2;

import java.util.Map;

public class UserFormControllerV2 implements ControllerV2 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}
