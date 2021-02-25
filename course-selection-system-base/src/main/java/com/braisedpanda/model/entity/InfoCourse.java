package com.braisedpanda.model.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课程信息表
 * </p>
 *
 * @author chenzhen
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="InfoCourse对象", description="课程信息表")
public class InfoCourse implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键ID")
      private Integer id;

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "教师ID")
    private Integer teacherId;

    @ApiModelProperty(value = "班级学生数量")
    private Integer studentNumber;

    @ApiModelProperty(value = "班级教室ID")
    private Integer roomId;

    @ApiModelProperty(value = "课程类型(1:专业课 2：公共课 3：选修课)")
    private Integer courseType;

    @ApiModelProperty(value = "排课ID")
    private Integer arrangeId;

    @ApiModelProperty(value = "创建者")
    private Integer createUser;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新者")
    private Integer updateUser;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;


}
