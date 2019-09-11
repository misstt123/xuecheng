package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CourseBase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author lyh-god
 * @Date 2019/9/10
 **/
public interface CourseBaseRepository extends JpaRepository<CourseBase,String> {
}
