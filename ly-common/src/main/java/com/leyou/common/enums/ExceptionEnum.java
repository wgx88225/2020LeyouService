package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName ExceptionEnum
 * @Description: 自定义异常枚举类
 * @Auther: vince
 * @Date: 2019/12/15 16:41
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NULL(400,"价格不能为空!")
    ;
    private int code;
    private String msg;
}
