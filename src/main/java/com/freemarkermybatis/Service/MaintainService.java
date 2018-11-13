package com.freemarkermybatis.Service;

import com.freemarkermybatis.dao.MessageDao;
import com.freemarkermybatis.generator.MessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintainService {

    @Autowired
    private MessageDao messageDao;
    /*
    * 单挑删除;
    * */
    public void  DeleteOne(String id)
    {
        if (id == null || "".equals(id.trim()))
        {
            return;
        }

        messageDao.deleteByPrimaryKey(Integer.valueOf(id));
        return;
    }

    /*
    * 批量删除;
    * */
    public void DeleteBath(String [] Ids)
    {
        List<Integer> iIds = new ArrayList<Integer>();
        for (String id: Ids) {
            if (id == null || "".equals(id.trim()))
            {
                continue;
            }

            iIds.add(Integer.valueOf(id));
        }

        if (iIds.size() == 0)
        {
            return;
        }

        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andIdIn(iIds);
        messageDao.deleteByExample(messageExample);
        return;
    }
}
