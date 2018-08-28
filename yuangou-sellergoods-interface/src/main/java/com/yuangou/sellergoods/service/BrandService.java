package com.yuangou.sellergoods.service;

import com.yuangou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: 烈日下的酋长
 * @Date: 2018/8/14 22:40
 * @Version 1.0
 */
public interface BrandService {

    List<TbBrand> findAll();

    PageResult findPage(int pageNum, int pageSize);

    void addBrand(TbBrand tbBrand);

    int update(TbBrand tbBrand);

    TbBrand findOne(Long id);

    void delete(Long[] ids);

    PageResult findPage(TbBrand brand, int pageNum, int pageSize);

    List<Map> selectOptionList();

    List<Map> findSpecifications();

}
