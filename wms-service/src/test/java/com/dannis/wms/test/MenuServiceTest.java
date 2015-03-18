package com.dannis.wms.test;

import com.dannis.wms.model.Menu;
import com.dannis.wms.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 14:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/spring/applicationContext-service.xml"})
public class MenuServiceTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private MenuService menuService;

    @Test
    public void testSave() {
        Menu menu = new Menu();
        menu.setName("订单管理");
        menu.setUrl("sfsf");
        menu.setCode("sfsfsf");
        menu.setRemark("师傅沙发上覆盖");
        menuService.save(menu);
    }
}
