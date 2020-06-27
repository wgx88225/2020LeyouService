package com.leyou.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.param.BrandParam;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName BrandServiceImpl
 * @Description: 品牌serviceImpl
 * @Auther: vince
 * @Date: 2019/11/25 17:55
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * @Description: 搜索+ 分页查询品牌分类
     * @Param: [brandParam]
     * @return: com.leyou.common.pojo.PageResult<com.leyou.item.pojo.Brand>
     * @Author: vince
     * @Date: 2019/11/25 18:36
     */
    @Override
    public PageResult<Brand> queryBrandByPage(BrandParam brandParam) {

        // 分页
        PageHelper.startPage(brandParam.getPage(), brandParam.getRowsPerPage());
        Example example = new Example(Brand.class);
        // 排序
        if (StringUtils.isNotBlank(brandParam.getSortBy())) {
            example.setOrderByClause(brandParam.getSortBy() + (brandParam.getDesc() ? " DESC" : " ASC"));
        }
        // 关键查询
         if(StringUtils.isNotBlank(brandParam.getKey())){
             example.createCriteria().orLike("name","%"+ brandParam.getKey()+"%").orEqualTo("letter",StringUtils.upperCase(brandParam.getKey()));
         }
        List<Brand> list = this.brandMapper.selectByExample(example);
        PageInfo<Brand> info = new PageInfo<>(list);
        return new PageResult<>(info.getTotal(),info.getList()) ;
    }
    /**
     * @Description:  新增品牌
     * @Param: [brand, ids] 新增品牌对象 和商品分类id
     * @return: void
     * @Author: vince
     * @Date: 2019/12/5 21:55
     */
    @Override
    @Transactional
    public int saveBrand(Brand brand, List<Long> ids) {
        // 1.先查询品牌名字是否占用；如果被占用返回 0
        Example example = new Example(Brand.class);
        example.createCriteria().andEqualTo("name",brand.getName());
        int status = this.brandMapper.selectCountByExample(example);
        if (status != 0) {
            return 0;
        }
        // 2.保存品牌
         status = this.brandMapper.insert(brand);
        // 3. 同时保存商品分类表
        for (Long cid : ids) {
            status = this.brandMapper.saveCategoryBrand(cid, brand.getId());
        }
        return status;
    }
}
