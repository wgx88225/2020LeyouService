package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


/**
 * @ClassName BrandMapper
 * @Description: 品牌Mapper
 * @Auther: vince
 * @Date: 2019/11/24 15:27
 */
public interface BrandMapper extends Mapper<Brand> {
    /**
     * @Description: 保存数据到 商品品牌中间表中
     * @Param: [cid, bid] cid:商品分类id;bid:品牌id
     * @return: int
     * @Author: vince
     * @Date: 2019/12/5 22:16
     */
   @Insert("INSERT INTO tb_category_brand(category_id, brand_id) VALUES (#{cid}, #{bid})")
    int saveCategoryBrand(@Param("cid") Long cid, @Param("bid")Long bid);
}
