package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @ClassName ExceptionResult
 * @Description: 异常结果类
 * @Auther: vince
 * @Date: 2019/12/15 16:58
 */
@Data
public class ExceptionResult {

    private int status;
    private String message;
    private Long timestamp;

   public ExceptionResult(ExceptionEnum e){
       this.status = e.getCode();
       this.message = e.getMsg();
       this.timestamp = System.currentTimeMillis();
   }
}
