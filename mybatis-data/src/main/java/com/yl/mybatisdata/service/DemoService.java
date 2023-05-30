package com.yl.mybatisdata.service;

import com.yl.mybatisdata.dto.PmsBrandDto;
import com.yl.mybatisdata.mbg.model.PmsBrand;

import java.util.List;

/**
 * @创建人 叶立
 * @创建时间 2023/5/30
 * @描述
 */
public interface DemoService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrandDto pmsBrandDto);

    int updateBrand(Long id, PmsBrandDto pmsBrandDto);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);

}
