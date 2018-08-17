package com.yuangou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yuangou.pojo.TbBrand;
import com.yuangou.sellergoods.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 烈日下的酋长
 * @Date: 2018/8/14 22:48
 * @Version 1.0
 */
@Controller
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<TbBrand> findAlls() {
        return brandService.findAll();
    }

}
