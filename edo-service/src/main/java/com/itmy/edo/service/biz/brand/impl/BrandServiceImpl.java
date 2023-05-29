package com.itmy.edo.service.biz.brand.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmy.edo.dao.mapper.BrandMapper;
import com.itmy.edo.model.entity.biz.Brand;
import com.itmy.edo.service.biz.brand.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService{

    @Resource
    private BrandMapper brandMapper;
    @Override
    @Cacheable(value = "brandCache", key = "#brandId")
    public Brand getBrandById(Long brandId) {
        return this.getById(brandId);
    }

    @Override
    @CachePut(value = "brandCache", key = "#brand.brandId")
    public void updateBrand(Brand brand) {
        this.saveOrUpdate(brand);
    }

    @Override
    public Brand addBrand(Brand brand) {
        log.info("brand:{}",brand);
        Brand brand1 = new Brand();
        brand1.setBrandName(brand.getBrandName());
        brand1.setRecTime(new Date());
        brand1.setMemo(brand.getMemo());
        brand1.setBrief(brand.getBrief());
        this.saveOrUpdate(brand1);
      return brand;
    }

    @Override
    @CacheEvict(value = "brandCache", key = "#brand_id")
    public void deleteBrandById(Long id) {
        this.removeById(id);
    }
}
