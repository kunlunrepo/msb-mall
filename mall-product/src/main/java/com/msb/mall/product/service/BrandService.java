package com.msb.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.mall.common.utils.PageUtils;
import com.msb.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author kunlunrepo
 * 
 * @date 2024-03-14 09:39:10
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

