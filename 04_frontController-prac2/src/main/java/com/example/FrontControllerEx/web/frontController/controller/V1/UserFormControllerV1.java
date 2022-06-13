package com.example.FrontControllerEx.web.frontController.controller.V1;

import com.example.FrontControllerEx.web.frontController.ModelView;

import java.util.Map;

public class UserFormControllerV1 implements ControllerV1 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
