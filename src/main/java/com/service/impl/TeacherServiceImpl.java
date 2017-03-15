package com.service.impl;

import com.bean.Teacher;
import com.dao.CommonDao;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuyu on 2016/10/19.
 */

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private CommonDao commonDao;

    public Teacher getTeacherById(long id) {
        return commonDao.getById(Teacher.class, id);
    }

    public void addTeacher(Teacher teacher) {
        commonDao.saveOrUpdate(teacher);
    }

    public void deleteById(long id) {
        commonDao.deleteById(Teacher.class,id);
    }
}
