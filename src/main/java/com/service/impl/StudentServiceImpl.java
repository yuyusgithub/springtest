package com.service.impl;

import com.bean.Student;
import com.dao.CommonDao;
import com.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuyu on 2016/10/19.
 */

@Service("studentServiceImpl")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private CommonDao commonDao;

    public void add(Student student) {
        commonDao.saveOrUpdate(student);
    }

    public void deleteById(Long id) {
        commonDao.deleteById(Student.class, id);
    }

    public Student getStudent(Long id) {
        Student student = commonDao.getById(Student.class, id);
        return student;
    }
}
