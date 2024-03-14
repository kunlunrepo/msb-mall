package com.msb.mall.product.dao;

import com.msb.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author kunlunrepo
 * 
 * @date 2024-03-14 09:39:10
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
