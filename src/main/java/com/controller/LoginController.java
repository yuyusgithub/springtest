package com.controller;

import com.bean.Student;
import com.bean.Teacher;
import com.bean.User;
import com.service.ICommonService;
import com.service.IStudentService;
import com.service.ITeacherService;
import com.service.IUserService;
import com.util.SomeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuyu on 2016/10/19.
 */

@Controller
public class LoginController {
    Logger logger = Logger.getLogger(LoginController.class);
    @Value("jdbc.driver")
    private String testInjectStr;


    //这个地方的自动注入是按 名称匹配的方式注入的，变量名与Service("xxxxxx")标签上的xxxxxx相匹配的
    //    @Autowired默认按类型装配，默认情况下必须要求依赖对象必须存在，如果要允许null值，可以设置它的required属性为false，
    //    例如：@Autowired(required=false) ，如果我们想使用名称装配可以结合@Qualifier注解进行使用，如下：
    //    @Autowired(required = true) 默认为true
    //    @Qualifier("baseDao")
    //    private BaseDao baseDao;

    //    @Resource，默认安装名称进行装配，名称可以通过name属性进行指定，如果没有指定name属性，当注解写在字段上时，默认取字段名进行安装名称查找，如果注解写在setter方法上默认取属性名进行装配。当找不到与名称匹配的bean时才按照类型进行装配。但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。
    //    @Resource(name="baseDao")
    //    private BaseDao baseDao;

    //    @Autowired和@Resource都可以用来装配bean，都可以写在字段上，或者方法上。
    @Autowired
    private IUserService userServiceImpl;

    @Autowired
    private ITeacherService teacherServiceImpl;

    @Autowired
    private IStudentService studentServiceImpl;
    @Autowired
    private SomeUtil somutil;
    @Autowired
    private ICommonService commonService;



    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request, HttpServletRequest response, Model model) {

        addTeacherAnaStudent();


        model.addAttribute("password", password);
        model.addAttribute("xxoo", testInjectStr);

        return "/login";
    }

    private String updateUser(String username, String password, HttpServletRequest response, Model model) {

        User user = userServiceImpl.getUserByName(username);

        String oldName = "";
        String oldPassWord = "";
        if(user != null){
            oldName = user.getName();
            oldPassWord = user.getPassword();
        }

        user.setName(username);
        user.setPassword(password);





//        model.addAttribute("name", name);
        model.addAttribute("password", password);
        model.addAttribute("xxoo", testInjectStr);


        return null;


    }

    private void addTeacherAnaStudent(){
//        clean();

        Student s1 = new Student();
        s1.setName("name1");
        s1.setAge(9);
        s1.setXxoo("xxoo");

        Student s2 = new Student();
        s2.setName("name1");
        s2.setAge(9);
        s2.setXxoo("xxoo");

        Set<Student> set = new HashSet<Student>();
        set.add(s1);
        set.add(s2);

        Teacher teacher = new Teacher();
        teacher.setClazz("ooxx");
        teacher.setName("tname1");
        teacher.setAge(9l);
//        teacherServiceImpl.addTeacher(teacher);


//        Teacher t = teacherServiceImpl.getTeacherById(1);
        teacher.setStudents(set);

        teacherServiceImpl.addTeacher(teacher);


        Teacher t1 = teacherServiceImpl.getTeacherById(1);
        teacherServiceImpl.delete(t1);

    }

    private void clean(){

//        commonService.clean(Student.class);

        commonService.clean(Teacher.class);


    }

}
