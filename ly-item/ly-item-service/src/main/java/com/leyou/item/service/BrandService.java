package com.leyou.item.service;

import com.leyou.common.param.BrandParam;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;

import java.util.List;

/**
 * @ClassName BrandService
 * @Description: 品牌Service
 * @Auther: vince
 * @Date: 2019/11/25 17:55
 */
public interface BrandService {
    /**
     * @Description: 搜索+ 分页查询品牌分类
     * @Param: [brandParam]
     * @return: com.leyou.common.pojo.PageResult<com.leyou.item.pojo.Brand>
     * @Author: vince
     * @Date: 2019/11/25 18:36
     */
    PageResult<Brand> queryBrandByPage(BrandParam brandParam);
   /**
    * @Description: 新增品牌
    * @Param: [brand, ids] 新增品牌对象 和商品分类id
    * @return: void
    * @Author: vince
    * @Date: 2019/12/5 21:54
    */
    int saveBrand(Brand brand, List<Long> ids);
}
