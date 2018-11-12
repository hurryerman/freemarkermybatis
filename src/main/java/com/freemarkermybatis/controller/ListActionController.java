package com.freemarkermybatis.controller;

import com.freemarkermybatis.mod.Message;
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
//        MessageDao dao = new MessageDao() {
//            @Override
//            public long countByExample(MessageExample example) {
//                return 0;
//            }
//
//            @Override
//            public int deleteByExample(MessageExample example) {
//                return 0;
//            }
//
//            @Override
//            public int deleteByPrimaryKey(Integer id) {
//                return 0;
//            }
//
//            @Override
//            public int insert(Message record) {
//                return 0;
//            }
//
//            @Override
//            public int insertSelective(Message record) {
//                return 0;
//            }
//
//            @Override
//            public List<Message> selectByExample(MessageExample example) {
//                return null;
//            }
//
//            @Override
//            public Message selectByPrimaryKey(Integer id) {
//                return null;
//            }
//
//            @Override
//            public int updateByExampleSelective(Message record, MessageExample example) {
//                return 0;
//            }
//
//            @Override
//            public int updateByExample(Message record, MessageExample example) {
//                return 0;
//            }
//
//            @Override
//            public int updateByPrimaryKeySelective(Message record) {
//                return 0;
//            }
//
//            @Override
//            public int updateByPrimaryKey(Message record) {
//                return 0;
//            }
//        }
//        List<message> listMessage = service.SearchMessageList(command, description);
        if (null != listMessage)
        {
            modelMap.addAttribute("ListMessage", listMessage);
        }

        return  "ListAction";
    }
}
