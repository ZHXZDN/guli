package com.atguigu.edu.service;

import com.atguigu.edu.dto.EduTeacherPageReqDTO;
import com.atguigu.edu.entity.EduTeacher;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author 张欢
 * @since 2021-02-17
 */
public interface EduTeacherService extends IService<EduTeacher> {

    IPage<EduTeacher> listByPage(EduTeacherPageReqDTO reqDTO);
}
