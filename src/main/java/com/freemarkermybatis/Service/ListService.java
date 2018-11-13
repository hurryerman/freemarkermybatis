package com.freemarkermybatis.Service;

import com.freemarkermybatis.dao.MessageDao;
import com.freemarkermybatis.generator.MessageExample;
import com.freemarkermybatis.mod.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {

    @Autowired
    private MessageDao messageDao;

    public List<Message> ListGet(String command, String description)
    {
        List<Message> listMessage = new ArrayList<Message>();
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();

        if (command != null && !"".equals(command.trim()))
        {
            criteria.andCommandEqualTo(command);
        }

        if (description != null && !"".equals(description.trim()))
        {
            criteria.andDescriptionLike("%"+description+"%");
        }

        listMessage = messageDao.selectByExample(example);
        return  listMessage;
    }
}
