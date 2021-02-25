package com.braisedpanda.course.service;

import com.braisedpanda.course.mapper.InfoCourseMapper;
import com.braisedpanda.model.entity.InfoCourse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程信息表 服务实现类
 * </p>
 *
 * @author chenzhen
 * @since 2021-02-25
 */
@Service
public class InfoCourseServiceImpl extends ServiceImpl<InfoCourseMapper, InfoCourse> implements IInfoCourseService {

}
