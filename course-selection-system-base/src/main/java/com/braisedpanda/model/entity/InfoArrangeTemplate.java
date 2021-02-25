package com.braisedpanda.model.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenzhen
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="InfoArrangeTemplate对象", description="")
public class InfoArrangeTemplate implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      private Integer id;

    @ApiModelProperty(value = "模板名称")
    private String templateName;

    @ApiModelProperty(value = "专业类型")
    private Integer disciplineType;

    @ApiModelProperty(value = "课程类型")
    private Integer courseType;

    @ApiModelProperty(value = "课程ID")
    private Integer courseId;

    @ApiModelProperty(value = "对应的坐标点")
    private Integer arrangePoint;

    @ApiModelProperty(value = "创建者")
    private Integer createUser;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新者")
    private Integer updateUser;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;


}
