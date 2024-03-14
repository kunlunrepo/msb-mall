package com.msb.mall.order.fegin;

import com.msb.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * description : 调用商品服务接口
 *
 * @author com.msb.mall.common
 * date :  2024-03-14 12:00
 */
@FeignClient(name = "mall-product")
public interface ProductService {

    /**
     * 查询所有
     */
    @GetMapping("/product/brand/all")
    public R queryAllBrand();

}
