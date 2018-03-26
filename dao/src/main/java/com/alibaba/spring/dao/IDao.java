package com.alibaba.spring.dao;

import java.util.List;

/**
 * Created by jack on 2018/3/26.
 */
public interface IDao<E> {

    /**
     * 查询
     *
     */
    /*******************************************************/
    List<E> queryAll();

    E queryById();

    E queryByQueryString(String string);
    /*******************************************************/

    /**
     * 增
     * 1 ->true
     * orther ->false
     */
    /*******************************************************/
    int insert(E e);

    int[] insert(List<E> eList);
    /*******************************************************/

    /**
     * 改
     *
     */
    /*******************************************************/
    int update(E e);

    int[] update(List<E> eList);
    /*******************************************************/

    /**
     * 删
     *
     */
    /*******************************************************/
    int delete(int id);

    int delete(E e);

    int[] delete(List<E> eList);
    /*******************************************************/


}
