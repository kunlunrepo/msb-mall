package com.msb.mall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msb.mall.common.utils.PageUtils;
import com.msb.mall.common.utils.Query;

import com.msb.mall.product.dao.CategoryDao;
import com.msb.mall.product.entity.CategoryEntity;
import com.msb.mall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询所有的类别数据(封装成树形结构)
     */
    @Override
    public List<CategoryEntity> queryPageWithTree(Map<String, Object> params) {
        // 1.查询所有的商品分类信息
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        // 2.将商品分类信息封装成树形结构
        // (1)遍历出所有的大类 (2)根据大类找对应的所有小类
        List<CategoryEntity> list = categoryEntities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0) // 过滤出所有大类
                .map(categoryEntity -> { // 根据大类找到对应的所有小类
                    List<CategoryEntity> subChildrens = getCategoryChildrens(categoryEntity, categoryEntities);
                    // 将小类添加到大类下
                    categoryEntity.setChildrens(subChildrens);
                    return categoryEntity;
                })
                .sorted((a, b) -> {
                    // 按照sort排序 小的在前
                    return (a.getSort() == null ? 0 : a.getSort()) - (b.getSort() == null ? 0 : b.getSort());
                })
                .collect(Collectors.toList());
        return list;
    }

    /**
     * 递归查找对应大类的所有小类
     * @param categoryEntity 具体大类
     * @param categoryEntities 所有分类
     * @return 大类下的所有小类
     */
    private List<CategoryEntity> getCategoryChildrens(CategoryEntity categoryEntity, List<CategoryEntity> categoryEntities) {
        List<CategoryEntity> subChildrens = categoryEntities.stream()
                .filter(entity -> entity.getParentCid() == categoryEntity.getCatId()) // 根据大类找到对应的小类
                .map(entity -> {
                    List<CategoryEntity> minniChildrens = getCategoryChildrens(entity, categoryEntities); // 根据小类找到对应的小小类
                    // 将小小类添加到小类中
                    entity.setChildrens(minniChildrens);
                    return entity;
                })
                .sorted((a, b) -> {
                    // 按照sort排序 小的在前
                    return (a.getSort() == null ? 0 : a.getSort()) - (b.getSort() == null ? 0 : b.getSort());
                })
                .collect(Collectors.toList());
        // 返回所有小类
        return subChildrens;
    }

}