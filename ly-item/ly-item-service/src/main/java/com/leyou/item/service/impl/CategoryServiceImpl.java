package com.leyou.item.service.impl;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName CategoryServiceImpl
 * @Description: 商品分类serviceImpl
 * @Auther: vince
 * @Date: 2019/11/24 15:32
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper  categoryMapper;

    /**
     * @Description: 通过父级ID查询商品分类
     * @Param: [pid] 父级ID
     * @return: java.util.List<com.leyou.item.pojo.Category>
     * @Author: vince
     * @Date: 2019/11/24 16:13
     */
    @Override
    public List<Category> queryCategoryByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        List<Category> categoryList = this.categoryMapper.select(category);
        return categoryList;
    }
    /**
     * @Description: 通过ID和Name更新商品分类
     * @Param: [category]
     * @return: int
     * @Author: vince
     * @Date: 2019/11/24 18:43
     */
    @Override
    @Transactional
    public int updateCategoryByIdAndName(Category c) {

        //因为只更新商品分类名称 所以先根据ID查询出来
        Category category = this.categoryMapper.selectByPrimaryKey(c.getId());
        category.setName(c.getName());
        // 组装好对象后，再更新
        return  this.categoryMapper.updateByPrimaryKey(category);

    }
    /**
     * @Description: 新增商品分类
     * @Param: [category]
     * @return: int
     * @Author: vince
     * @Date: 2019/11/24 19:09
     */
    @Override
    @Transactional
    public int addCategory(Category c) {
        // 改节点的父节点 是否为父节点改为true
        Category category = this.categoryMapper.selectByPrimaryKey(c.getParentId());
        category.setIsParent(true);
        categoryMapper.insert(c);
        int i = this.categoryMapper.updateByPrimaryKey(category);
        return i;
    }
    /**
     * @Description: 通过ID删除商品分类 (递归删除)
     * @Param: [id]
     * @return: int
     * @Author: vince
     * @Date: 2019/11/24 19:31
     */
    @Override
    @Transactional
    public int deleteCategoryById(Long id) {


        List<Category> list = this.categoryMapper.selectAll();
       this.getChild(id, list);
       this.categoryMapper.deleteByPrimaryKey(id);
       return 1;
    }

     /**
      * @Description:  需要递归删除分类
      * @Param: [id, list]
      * @return: boolean
      * @Author: vince
      * @Date: 2019/11/24 19:36
      */

    private List<Category> getChild(Long id, List<Category> AllList){

        List<Category> childList = new ArrayList<>();
        for (Category c: AllList) {
            if(c.getParentId().longValue() == id){
                childList.add(c);
                this.categoryMapper.deleteByPrimaryKey(c.getId());
            }
        }
        // 递归
        for (Category c1:childList) {
            c1.setChildren(getChild(c1.getId(),AllList));
        }
        if(childList.size() == 0){
            return  new ArrayList<Category>();
        }

        return childList;
    }
}
