package com.xuecheng.framework.domain.learning.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description:
 * @Author lyh-god
 * @Date 2019/9/11
 **/
@Data
@ToString
@NoArgsConstructor
public class GetMediaResult extends ResponseResult {
    //视频播放地址
    String fileUrl;
    public GetMediaResult(ResultCode resultCode,String fileUrl){
        super(resultCode);
        this.fileUrl = fileUrl;
    }
}
