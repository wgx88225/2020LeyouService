package com.leyou.item.controller;

import com.leyou.common.advice.CommonExceptionHandler;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.param.BrandParam;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BrandController
 * @Description: 品牌分类controller
 * @Auther: vince
 * @Date: 2019/11/24 15:35
 */
@RestController
@RequestMapping("brand")
public class BrandController {
    private final static Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;



   /**
    * @Description:  搜索+ 分页查询品牌分类
    * @Param: [brandParam]
    * @return: org.springframework.http.ResponseEntity<com.leyou.common.pojo.PageResult<com.leyou.item.pojo.Brand>>
    * @Author: vince
    * @Date: 2019/11/25 18:24
    */
    @PostMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(@RequestBody BrandParam brandParam){
        logger.info("搜索+ 分页查询品牌分类查询参数Param：{}",brandParam.toString());
        PageResult<Brand> result = this.brandService.queryBrandByPage(brandParam);
        if(result == null){
            // 没找到 返回404
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        logger.info("搜索+ 分页查询品牌分类查询 Result：{}",result);
        return  ResponseEntity.ok(result);
    }
    /**
     * @Description: 新增品牌
     * @Param: [brand, ids] 新增品牌对象 和商品分类id
     * @return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: vince
     * @Date: 2019/12/5 21:53
     */
    @PostMapping("add")
    public ResponseEntity<Integer> saveBrand( Brand brand, @RequestParam("categories")List<Long> ids){
        logger.info("新增品牌分类查询参数brand：{}，ids:{}",brand.toString(),ids);
        int status = this.brandService.saveBrand(brand, ids);
        return  ResponseEntity.ok(status);
    }

    @GetMapping("id")
    public ResponseEntity<Integer> getTest(Integer id){
        if(id == 1){
            throw new LyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
        }
        return  ResponseEntity.ok(1);
    }
}
