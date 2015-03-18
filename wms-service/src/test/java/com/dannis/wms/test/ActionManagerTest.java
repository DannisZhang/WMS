package com.dannis.wms.test;

import com.dannis.wms.manager.ActionManager;
import com.dannis.wms.model.Action;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 14:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/spring/applicationContext-service.xml"})
public class ActionManagerTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private ActionManager actionManager;

    @Test
    public void testSave() {
        Action action = new Action();
        action.setName("删除订单");
        action.setCode("00001");
        action.setUrl("1");
        action.setRemark("remark");
        actionManager.save(action);
    }
}
