package com.yl.mybatisdata.controller;

import com.yl.common.api.CommonResult;
import com.yl.mybatisdata.mbg.model.PmsBrand;
import com.yl.mybatisdata.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @创建人 叶立
 * @创建时间 2023/5/30
 * @描述 mybatis增删改查
 */
@Api(tags = "DemoController", description = "增删改查",value = "增删改查value")
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ApiOperation(value = "查询列表")
    @PostMapping(value = "/api/brand/listAll")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(demoService.listAllBrand());
    }

}
