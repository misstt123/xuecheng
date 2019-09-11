package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author lyh-god
 * @Date 2019/9/7
 **/
@Data
@NoArgsConstructor//无参构造器注解
public class CmsPostPageResult extends ResponseResult {
    String pageUrl;
    public CmsPostPageResult(ResultCode resultCode, String pageUrl) {
        super(resultCode);
        this.pageUrl = pageUrl;
    }
}
