package com.yuangou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yuangou.mapper.TbBrandMapper;
import com.yuangou.pojo.TbBrand;
import com.yuangou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * @Author: 烈日下的酋长
 * @Date: 2018/8/14 22:44
 * @Version 1.0
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {

        return brandMapper.selectByExample(null);
    }
}
