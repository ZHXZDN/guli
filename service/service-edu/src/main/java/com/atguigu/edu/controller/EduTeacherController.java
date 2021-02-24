package com.atguigu.edu.controller;


import com.atguigu.common.utils.R;
import com.atguigu.edu.dto.EduTeacherPageReqDTO;
import com.atguigu.edu.entity.EduTeacher;
import com.atguigu.edu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 张欢
 * @since 2021-02-17
 */
@Api(value = "讲师管理")
@RestController
@RequestMapping("/edu/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/findAll")
    public R findAll() {
        return R.success().data("data", teacherService.list(null));
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("/deleteById/{teacherId}")
    public R deleteById(@PathVariable("teacherId") Long teacherId) {
        return teacherService.removeById(teacherId) == true ? R.success() : R.fail();
    }

    @ApiOperation(value = "分页列表")
    @PostMapping("/listByPage")
    public R listByPage(@RequestBody @Validated EduTeacherPageReqDTO reqDTO) {
        IPage<EduTeacher> queryPage = teacherService.listByPage(reqDTO);
        if (CollectionUtils.isEmpty(queryPage.getRecords())) {
            return R.success().data("data", null);
        }
        return R.success().data("data", queryPage.getRecords()).data("total", queryPage.getTotal());
    }

}

