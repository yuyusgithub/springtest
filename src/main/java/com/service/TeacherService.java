package com.service;

import com.bean.Teacher;

/**
 * Created by yuyu on 2016/10/19.
 */
public interface TeacherService {
    Teacher getTeacherById(long tName);
    void addTeacher(Teacher teacher);
    void deleteById(long id);
}
