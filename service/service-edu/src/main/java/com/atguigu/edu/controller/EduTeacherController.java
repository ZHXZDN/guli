package com.atguigu.edu.controller;


import com.atguigu.edu.entity.EduTeacher;
import com.atguigu.edu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    public List<EduTeacher> findAll(){
        return teacherService.list(null);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("/deleteById/{teacherId}")
    public Boolean deleteById(@PathVariable("teacherId") Long teacherId){
        return teacherService.removeById(teacherId);
    }
}

