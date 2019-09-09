package com.xuecheng.framework.model.response;

import lombok.Data;
import lombok.ToString;

/**
 * @Description:
 * @Author lyh-god
 * @Date 2019/9/8
 **/
@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {

    QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
