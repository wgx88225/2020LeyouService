package com.leyou.common.param;

/**
 * @ClassName BrandParam
 * @Description: 品牌请求参数类
 * @Auther: vince
 * @Date: 2019/11/25 18:16
 */
public class BrandParam {
    /**
     - page：当前页，int
     - rows：每页大小，int
     - sortBy：排序字段，String
     - desc：是否为降序，boolean
     - key：搜索关键词，String
     */

    private Integer page ;

    private Integer rowsPerPage ;

    private String sortBy;

    private Boolean desc = false;

    private String key;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(Integer rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Boolean getDesc() {
        return desc;
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null?"":key.trim();
    }

    @Override
    public String toString() {
        return "BrandParam{" +
                "page=" + page +
                ", rowsPerPage=" + rowsPerPage +
                ", sortBy='" + sortBy + '\'' +
                ", desc=" + desc +
                ", key='" + key + '\'' +
                '}';
    }
}
