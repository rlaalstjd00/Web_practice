package com.example.FrontControllerEx.web.frontController.adapter;

import com.example.FrontControllerEx.web.frontController.HandlerAdapterInterface;
import com.example.FrontControllerEx.web.frontController.ModelView;
import com.example.FrontControllerEx.web.frontController.controller.V1.ControllerV1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV1HandlerAdapter implements HandlerAdapterInterface {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV1);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV1 controller = (ControllerV1) handler;

        Map<String, String> paramMap = createParamMap(request);
        ModelView modelView = controller.process(paramMap);

        return modelView;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
