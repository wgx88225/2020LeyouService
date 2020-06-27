package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description: 商品分类Service
 * @Auther: vince
 * @Date: 2019/11/24 15:31
 */
public interface CategoryService {
    /**
     * @Description: 通过父级ID查询商品分类
     * @Param: [pid] 父级ID
     * @return: java.util.List<com.leyou.item.pojo.Category>
     * @Author: vince
     * @Date: 2019/11/24 16:12
     */
    List<Category> queryCategoryByPid(Long pid);
    /**
     * @Description: 通过ID和Name更新商品分类
     * @Param: [category]
     * @return: int
     * @Author: vince
     * @Date: 2019/11/24 18:43
     */
    int updateCategoryByIdAndName(Category category);
    /**
     * @Description: 新增商品分类
     * @Param: [category]
     * @return: int
     * @Author: vince
     * @Date: 2019/11/24 19:08
     */
    int addCategory(Category category);
     /**
      * @Description: 通过ID删除商品分类
      * @Param: [id]
      * @return: int
      * @Author: vince
      * @Date: 2019/11/24 19:31
      */
    int deleteCategoryById(Long id);
}
