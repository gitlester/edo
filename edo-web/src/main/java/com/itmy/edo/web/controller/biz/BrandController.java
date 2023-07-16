package com.itmy.edo.web.controller.biz;

import cn.licoy.encryptbody.annotation.encrypt.EncryptBody;
import com.itmy.edo.common.response.Result;
import com.itmy.edo.model.entity.biz.Brand;
import com.itmy.edo.service.biz.brand.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@EncryptBody
@Api(tags = "品牌管理")
@RestController
@RequestMapping("/admin/biz/brand")
public class BrandController {
    @Resource
    private BrandService brandService;

    @ApiOperation(value = "获取全部品牌列表")
    @GetMapping("/findAll")
    public Result<List<Brand>> findAll() {
        List<Brand> brandList = brandService.list();
        return Result.ok(brandList);
    }

    @ApiOperation(value = "逻辑删除角色")
    @DeleteMapping("remove/{id}")
    public Result<Boolean> del(@PathVariable("id") Long id){
        brandService.deleteBrandById(id);
        return Result.ok();
    }


    @ApiOperation(value = "获取品牌信息")
    @GetMapping("/get")
    public Brand getBrandById(@RequestParam("id") Long id) {
        return brandService.getBrandById(id);
    }

    @ApiOperation(value = "更新品牌信息")
    @PutMapping("/edit")
    public Brand updateBrand(@RequestBody Brand  brand) {
        brandService.updateBrand(brand);
        return brand;
    }

    @ApiOperation(value = "新增品牌信息")
    @PostMapping("/add")
    public Brand addBrand(@RequestBody Brand brand) {
        return brandService.addBrand(brand);
    }

}
