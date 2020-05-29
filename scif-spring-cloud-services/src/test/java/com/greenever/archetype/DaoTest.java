package com.greenever.archetype;

import com.greenever.archetype.dao.OpenAccountOnlineApplicationDao;
import com.greenever.archetype.po.OpenAccountOnlineApplication;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author cuik
 * @date 2020/5/29 15:59
 */
public class DaoTest extends BaseTest {

    @Resource
    private OpenAccountOnlineApplicationDao openAccountOnlineApplicationDao;


    @Test
    public void testSelectById() {
        OpenAccountOnlineApplication result = openAccountOnlineApplicationDao.selectById(276436308107497472L);
        System.out.println("result:" + result);
    }

    @Test
    public void testUpdateById() {
        OpenAccountOnlineApplication entity= new OpenAccountOnlineApplication();
        entity.setApplyId(270282808042491904L);
        entity.setIdNameEn("yang xing");
        int result  = openAccountOnlineApplicationDao.updateById(entity);
        System.out.println("result:" + result);
    }

}
