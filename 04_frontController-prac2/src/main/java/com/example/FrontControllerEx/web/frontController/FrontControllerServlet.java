package com.example.FrontControllerEx.web.frontController;

import com.example.FrontControllerEx.web.frontController.adapter.ControllerV1HandlerAdapter;
import com.example.FrontControllerEx.web.frontController.adapter.ControllerV2HandlerAdapter;
import com.example.FrontControllerEx.web.frontController.controller.V1.UserFormControllerV1;
import com.example.FrontControllerEx.web.frontController.controller.V1.UserSaveControllerV1;
import com.example.FrontControllerEx.web.frontController.controller.V2.UserFormControllerV2;
import com.example.FrontControllerEx.web.frontController.controller.V2.UserSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", urlPatterns = "/front-controller/*")
public class FrontControllerServlet extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<HandlerAdapterInterface> handlerAdapters = new ArrayList<>();

    public FrontControllerServlet() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap(){
        handlerMappingMap.put("/front-controller/v1/new-form", new UserFormControllerV1());
        handlerMappingMap.put("/front-controller/v1/save", new UserSaveControllerV1());

        handlerMappingMap.put("/front-controller/v2/new-form", new UserFormControllerV2());
        handlerMappingMap.put("/front-controller/v2/save", new UserSaveControllerV2());
    }

    private void initHandlerAdapters(){
        handlerAdapters.add(new ControllerV1HandlerAdapter());
        handlerAdapters.add(new ControllerV2HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);

        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        HandlerAdapterInterface adapter = getHandlerAdapter(handler);

        ModelView modelView = adapter.handle(request, response, handler);

        String viewName = modelView.getViewName();
        MyView view = viewResolver(viewName);

        view.render(modelView.getModel(), request, response);

    }

    // 핸들러 가져오는 메서드
    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    // 어댑터가 핸들러를 지원하는지 확인하는 메서드
    private HandlerAdapterInterface getHandlerAdapter(Object handler) {
        for (HandlerAdapterInterface adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter 찾을 수 없음! handler : " + handler);
    }
    
    // view의 논리명을 전체 경로로 만들어주는 메서드
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
