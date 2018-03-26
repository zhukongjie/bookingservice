package com.alibaba.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

/** 基础类
 * Created by jack on 2018/3/26.
 */
public class BaseDao<entity> implements IDao<entity> {

    /**
     * 初始化session
     */
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
            Configuration config = new Configuration().configure();
            ServiceRegistry serviceRegistry=
                    new ServiceRegistryBuilder().applySettings(config.getProperties())
                            .buildServiceRegistry();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        }
        catch(Throwable e)
        {
            throw new ExceptionInInitializerError(e);
        }
    }


    @Override
    public List<entity> queryAll() {
        Session session = sessionFactory.openSession();

        return null;
    }

    @Override
    public entity queryById() {
        return null;
    }

    @Override
    public entity queryByQueryString(String string) {
        return null;
    }

    @Override
    public int insert(entity entity) {
        return 0;
    }

    @Override
    public int[] insert(List<entity> entities) {
        return new int[0];
    }

    @Override
    public int update(entity entity) {
        return 0;
    }

    @Override
    public int[] update(List<entity> entities) {
        return new int[0];
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(entity entity) {
        return 0;
    }

    @Override
    public int[] delete(List<entity> entities) {
        return new int[0];
    }
}
