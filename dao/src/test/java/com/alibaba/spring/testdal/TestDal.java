package com.alibaba.spring.testdal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.util.List;


/**
 * Created by jack on 2018/3/19.
 */
public class TestDal {

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

    @Test
    public  void testHibernate(){

        Session session =  sessionFactory.openSession();
        List list = session.createSQLQuery(String.format("select * from mokeyhouse")).list();
        System.out.println(list.get(0).toString());

    }
}
