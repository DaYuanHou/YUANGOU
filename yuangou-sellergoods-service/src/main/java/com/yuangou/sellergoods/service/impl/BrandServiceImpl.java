package com.yuangou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuangou.mapper.TbBrandMapper;
import com.yuangou.pojo.TbBrand;
import com.yuangou.pojo.TbBrandExample;
import com.yuangou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    /**
     * @param pageNum
     * @param pageSize
     * @return分页的大小
     */

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> pages = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(pages.getTotal(), pages.getResult());
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void addBrand(TbBrand tbBrand) {
        brandMapper.insert(tbBrand);
    }

    @Override
    public int update(TbBrand tbBrand) {
        int a = brandMapper.updateByPrimaryKey(tbBrand);
        return a;

    }

    @Override
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids
        ) {
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (brand.getName() != null && brand.getName().length() > 0) {
                criteria.andNameLike("%" + brand.getName() + "%");
            }
            if (brand.getFirstChar() != null && brand.getFirstChar().length() > 0) {
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }

    @Override
    public List<Map> findSpecifications() {
        return brandMapper.findSpecifications();
    }

}
