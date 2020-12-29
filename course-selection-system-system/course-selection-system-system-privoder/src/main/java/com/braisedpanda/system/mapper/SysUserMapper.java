package com.braisedpanda.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.braisedpanda.model.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Service
 * @param
 * @return
 * @author chenzhen
 * @date 2020/12/29 0029
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
