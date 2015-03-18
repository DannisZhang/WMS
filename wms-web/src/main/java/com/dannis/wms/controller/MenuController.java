package com.dannis.wms.controller;

import com.dannis.wms.model.Menu;
import com.dannis.wms.query.QueryParams;
import com.dannis.wms.query.result.BaseResult;
import com.dannis.wms.query.result.PaginationQueryResult;
import com.dannis.wms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-17 15:16
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    /**
     * 系统菜单服务
     */
    @Autowired
    private MenuService menuService;

    /**
     * 添加系统菜单
     *
     * @param menu 菜单对象
     * @return 添加结果
     */
    @RequestMapping(value = "/add.json",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult add(Menu menu) {
        BaseResult result = new BaseResult();
        try {
            menuService.save(menu);
            result.setCode(BaseResult.ResultCode.SUCCESS);
            result.setMessage("添加菜单成功");
        } catch (Exception e) {
            //TODO:Log here
            e.printStackTrace();
            result.setCode(BaseResult.ResultCode.FAILED);
            result.setMessage("添加菜单失败");
        }
        return result;
    }

    /**
     * 根据编码删除系统菜单
     *
     * @param code 菜单编码
     * @return 删除结果
     */
    @RequestMapping(value = "/delete.json",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete(String code) {
        BaseResult result = new BaseResult();
        menuService.delete(code);
        result.setCode(BaseResult.ResultCode.SUCCESS);
        return result;
    }

    /**
     * 根据编码批量删除菜单
     *
     * @param codes 菜单编码列表
     * @return 删除执行结果
     */
    @RequestMapping(value = "/deleteByCodes.json",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult deleteByCodes(String[] codes) {
        BaseResult result = new BaseResult();
        try {
            menuService.deleteByCodes(Arrays.asList(codes));
            result.setCode(BaseResult.ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO:Log here
            result.setCode(BaseResult.ResultCode.FAILED);
        }
        return result;
    }

    @RequestMapping(value = "/findByPage.json",method = RequestMethod.POST)
    @ResponseBody
    public PaginationQueryResult<Menu> findByPage(QueryParams queryParams) {
        PaginationQueryResult<Menu> result = new PaginationQueryResult<>();
        try {
            result = menuService.findByPage(queryParams);
            result.setCode(BaseResult.ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO:log here
            result.setCode(BaseResult.ResultCode.FAILED);
            result.setMessage("查询系统菜单失败");
        }

        return result;
    }
}
