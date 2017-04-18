package com.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yuyu on 2016/11/5.
 */
@Repository("commonDao")
public class CommonDao {
    private static Logger logger = Logger.getLogger(CommonDao.class);


//    1.openSession和getCurrentSession的区别？
//            *openSession必须关闭，currentSession在事务结束后自动关闭
//    *openSession没有和当前线程绑定，currentSession和当前线程绑定
//    2.如果使用currentSession需要在hibernate.cfg.xml文件中进行配置：
//            *如果是本地事务（jdbc事务）
//    <propertyname="hibernate.current_session_context_class">thread</property>
//            *如果是全局事务（jta事务）
//    <propertyname="hibernate.current_session_context_class">jta</property>
//    全局事务：资源管理器管理和协调的事务，可以跨越多个数据库和进程。资源管理器一般使用XA 二阶段提交协议与“企业信息系统”(EIS) 或数据库进行交互。
//    本地事务：在单个 EIS或数据库的本地并且限制在单个进程内的事务。本地事务不涉及多个数据来源。

    @Autowired
    private SessionFactory sessionFactory;

    public <T> void saveOrUpdate(T object) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.saveOrUpdate(object);
            session.flush();
        } catch (HibernateException e) {
            logger.error("",e);
        } finally {
             session.close();
        }
    }

    public <T> void deleteById(Class<T> clazz,String  id) {
        String hql = "delete "+clazz.getSimpleName()+" where id = :id";
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.createQuery(hql).setString("id",id).executeUpdate();
            session.flush();
        } catch (HibernateException e) {
            logger.error("dfdfdfdf",e);
        } finally {
            session.close();
        }
    }

    public <T> void deleteById(Class<T> clazz,Long  id) {
        String hql = "delete "+clazz.getSimpleName()+" where id = :id";
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.createQuery(hql).setLong("id",id).executeUpdate();
            session.flush();
        } catch (HibernateException e) {
            logger.error("dfdfdfdf",e);
        } finally {
            session.close();
        }
    }

    public <T> void delete(T t){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.delete(t);
            session.flush();
        } catch (HibernateException e) {
            logger.error("dfdfdfdf",e);
        } finally {
            session.close();
        }
    }

    public <T> T getById(Class<T> clazz, String id) {
        Session session = null;
        T t = null;
        try {
            session = sessionFactory.openSession();
            t = (T) session.get(clazz, id);
        } catch (HibernateException e) {
            logger.error("");
        } finally {
            session.close();
        }
        return t;
    }

    public <T> T getById(Class<T> clazz, long id) {
        Session session = null;
        T t = null;
        try {
            session = sessionFactory.openSession();
            t = (T) session.get(clazz, id);
        } catch (HibernateException e) {
            logger.error("");
        } finally {
            session.close();
        }
        return t;
    }

    public <T> List<T> getAll(Class<T> clazz) {
        Session session = null;
        List<T> list = null;
        try {
            session = sessionFactory.openSession();
            Criteria c = session.createCriteria(clazz);
            list = c.list();
        } catch (HibernateException e) {
            logger.error("");
        } finally {
            session.close();
        }
        return list;
    }

    public void clean(Class clazz){
        String hql = "delete "+clazz.getSimpleName();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.createQuery(hql).executeUpdate();
            session.flush();
        } catch (HibernateException e) {
            logger.error("dfdfdfdf",e);
        } finally {
            session.close();
        }
    }
}
