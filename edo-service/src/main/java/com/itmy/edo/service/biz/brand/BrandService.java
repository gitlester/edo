package com.itmy.edo.service.biz.brand;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmy.edo.model.entity.biz.Brand;

/**
 * @author limeng
 */
public interface BrandService extends IService<Brand> {
    Brand getBrandById(Long id);

    void updateBrand(Brand brand);

    Brand addBrand(Brand brand);

    void deleteBrandById(Long id);
}
