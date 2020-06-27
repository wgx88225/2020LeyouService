package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CategoryController
 * @Description: 商品分类controller
 * @Auther: vince
 * @Date: 2019/11/24 15:35
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * @Description:  通过父级ID查询商品分类
     * @Param: [pid] 父级ID
     * @return: java.util.List<com.leyou.item.pojo.Category>
     * @Author: vince
     * @Date: 2019/11/24 16:11
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>>  queryCategoryByPid(@RequestParam("pid") Long pid){
        List<Category> list =  this.categoryService.queryCategoryByPid(pid);
        if(list.isEmpty()){
            // 没找到 返回404
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        // 找到 返回200
        return  ResponseEntity.ok(list);
    }
    /**
     * @Description:  通过ID和Name更新商品分类
     * @Param: [category]
     * @return: org.springframework.http.ResponseEntity<java.lang.Integer>
     * @Author: vince
     * @Date: 2019/11/24 18:42
     */
    @PutMapping("update")
    public ResponseEntity<Integer>  updateCategoryByIdAndName(@RequestBody Category category){
       int status =  this.categoryService.updateCategoryByIdAndName(category);
        if(status != 1){
            // 没找到 返回404
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        // 找到 返回200
        return  ResponseEntity.ok(status);
    }
     /**
      * @Description: 新增商品分类
      * @Param: [category]
      * @return: org.springframework.http.ResponseEntity<java.lang.Integer>
      * @Author: vince
      * @Date: 2019/11/24 19:08
      */ 
    @PostMapping("add")
    public ResponseEntity<Integer>  addCategory(@RequestBody Category category){
        int status =  this.categoryService.addCategory(category);
        if(status != 1){
            // 没找到 返回404
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        // 找到 返回200
        return  ResponseEntity.ok(status);
    }
    /**
     * @Description: 通过ID删除商品分类
     * @Param: [id] 商品分类 id
     * @return: org.springframework.http.ResponseEntity<java.lang.Integer>
     * @Author: vince
     * @Date: 2019/11/24 19:30
     */
    @DeleteMapping ("delete")
    public ResponseEntity<Integer>  deleteCategoryById(@RequestParam("id") Long id){
        int status =  this.categoryService.deleteCategoryById(id);
        if(status != 1){
            // 没找到 返回404
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        // 找到 返回200
        return  ResponseEntity.ok(status);
    }
}
