package com.freemarkermybatis.controller;

import com.freemarkermybatis.dao.MessageDao;
import com.freemarkermybatis.generator.MessageExample;
import com.freemarkermybatis.mod.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/*
* 列表页面初始化;
* */
@Controller
public class ListActionController {

    @Autowired
    private MessageDao messageDao;

    @RequestMapping("/ListAction")
    public String ListAction(ModelMap modelMap) throws UnsupportedEncodingException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        request.setCharacterEncoding("UTF-8");
        HttpServletResponse response = requestAttributes.getResponse();
        String command = request.getParameter("command");
        String description = request.getParameter("description");

        response.setCharacterEncoding("UTF-8");

        request.setAttribute("command",command);
        request.setAttribute("description", description);
        List<Message> listMessage = new ArrayList<Message>();

        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();

        if (command != null)
        {
            criteria.andCommandEqualTo(command);
        }

        if (description != null && !"".equals(description.trim()))
        {
            criteria.andDescriptionLike("%"+description+"%");
        }

        listMessage = messageDao.selectByExample(example);
//        List<message> listMessage = service.SearchMessageList(command, description);
        if (null != listMessage)
        {
            modelMap.addAttribute("ListMessage", listMessage);
        }

        //测试同步;
        return  "ListAction";
    }
}
