package com.atguigu.edu.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @ClassName: EduTeacherPageReqDTO
 * @Description: 教师列表入参
 * @Author: 张欢
 * @Date 2021/2/24 22:43
 * @Version: 1.0
 */
@Data
@Validated
public class EduTeacherPageReqDTO {

    @ApiModelProperty("当前页码")
    @NotNull(message = "当前页码不能为空")
    private Integer page;

    @NotNull(message = "每页记录数不能为空")
    @ApiModelProperty("每页记录数")
    private Integer size;

    @ApiModelProperty(value = "教师名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private LocalDateTime begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private LocalDateTime end;
}
