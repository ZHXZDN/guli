package com.atguigu.edu.service.impl;

import com.atguigu.edu.dto.EduTeacherPageReqDTO;
import com.atguigu.edu.entity.EduTeacher;
import com.atguigu.edu.mapper.EduTeacherMapper;
import com.atguigu.edu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author 张欢
 * @since 2021-02-17
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public IPage<EduTeacher> listByPage(EduTeacherPageReqDTO reqDTO) {
        // 分页页码,每页记录数
        Page<EduTeacher> page = new Page<>(reqDTO.getPage(), reqDTO.getSize());
        QueryWrapper wrapper = new QueryWrapper<EduTeacher>();
        if (StringUtils.isNotEmpty(reqDTO.getName())) {
            wrapper.like("name", reqDTO.getName());
        }
        if (reqDTO.getLevel() != null) {
            wrapper.eq("level", reqDTO.getLevel());
        }
        if (reqDTO.getBegin() != null) {
            wrapper.ge("gmt_create", reqDTO.getBegin());
        }
        if (reqDTO.getEnd() != null) {
            wrapper.le("gmt_create", reqDTO.getEnd());
        }
        return page(page,wrapper);
    }
}
