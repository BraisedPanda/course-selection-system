package com.braisedpanda.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.braisedpanda.course.mapper.InfoArrangeTemplateMapper;
import com.braisedpanda.model.entity.InfoArrangeTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenzhen
 * @since 2021-02-25
 */
@Service
public class InfoArrangeTemplateServiceImpl extends ServiceImpl<InfoArrangeTemplateMapper, InfoArrangeTemplate> implements IService<InfoArrangeTemplate> {

}
