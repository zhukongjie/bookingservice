package com.alibaba.spring.dao;



import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基础类
 * Created by jack on 2018/3/26.
 */
public class BaseDao<entity> /*extends HibernateDaoSupport*/ implements IDao<entity> {


    /*@Resource(name = "sessionFactory")
    public void setMySessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }*/

    private Class<entity> clz;

    @SuppressWarnings("unchecked")
    public Class<entity> getClz() {
        if (clz == null) {
            clz = (Class<entity>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clz;
    }


    @Override
    public List<entity> queryAll() {
        return null;//this.getHibernateTemplate().loadAll(clz);
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
