package com.service;

import com.bean.Student;

/**
 * Created by yuyu on 2016/11/7.
 */
public interface StudentService {

    void add(Student student);
    void deleteById(Long id);

    Student getStudent(Long id);
}
