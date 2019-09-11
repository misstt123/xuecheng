package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @Author lyh-god
 * @Date 2019/9/10
 **/
@Mapper
public interface TeachplanMapper {
    //课程计划查询
    public TeachplanNode selectList(String courseId);
}
