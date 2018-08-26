package com.yuangou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yuangou.pojo.TbBrand;
import com.yuangou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: 烈日下的酋长
 * @Date: 2018/8/14 22:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAlls() {
        return brandService.findAll();
    }


    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam int page, @RequestParam int size) {
        return brandService.findPage(page, size);
    }

    @RequestMapping("/add")
    public Result addBrand(@RequestBody TbBrand tbBrand) {

        try {
            brandService.addBrand(tbBrand);
            return new Result(true, "保存成功");
        } catch (Exception e) {
            return new Result(false, "保存失败");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return new Result(true, "修改成功！");
        } catch (Exception e) {
            return new Result(false, "修改失败！");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand, int page, int rows) {
        return brandService.findPage(brand, page, rows);
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList() {
        return brandService.selectOptionList();
    }

}
