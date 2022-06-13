package com.example.FrontControllerEx.web.frontController.controller.V1;

import com.example.FrontControllerEx.web.frontController.ModelView;

import java.util.Map;

public interface ControllerV1 {
    ModelView process(Map<String,String> paramMap);
}
