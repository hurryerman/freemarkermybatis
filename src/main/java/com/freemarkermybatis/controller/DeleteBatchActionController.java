package com.freemarkermybatis.controller;

import com.freemarkermybatis.Service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class DeleteBatchActionController {

    @Autowired
    private MaintainService maintainService;

    @RequestMapping("/DeleteBatchAction")
    public String DeleteBatchAction(ModelMap modelMap) throws UnsupportedEncodingException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        request.setCharacterEncoding("UTF-8");
        HttpServletResponse response = requestAttributes.getResponse();
        String[] Ids = request.getParameterValues("Id");

        response.setCharacterEncoding("UTF-8");

        maintainService.DeleteBath(Ids);

        try {
            request.getRequestDispatcher("/ListAction").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //测试同步;
        return  "ListAction";
    }
}
