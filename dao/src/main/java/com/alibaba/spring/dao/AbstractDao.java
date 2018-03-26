/*

public abstract class AbstractDao<T>  {


    */
/**
     * Query T by the specified ID
     * The ID must be a number
     **//*

    public T queryByPk(Number id, DalHints hints)
            throws SQLException {
        hints = DalHints.createIfAbsent(hints);
        return client.queryByPk(id, hints);
    }

    */
/**
     * Query T by T instance which the primary key is set
     **//*

    public T queryByPk(T pk, DalHints hints)
            throws SQLException {
        hints = DalHints.createIfAbsent(hints);
        return client.queryByPk(pk, hints);
    }

    */
/**
     * Query against sample pojo. All not null attributes of the passed in pojo
     * will be used as search criteria.
     **//*

    public List<T> queryLike(T sample, DalHints hints)
            throws SQLException {
        hints = DalHints.createIfAbsent(hints);
        return client.queryLike(sample, hints);
    }

    */
/**
     * Get the all records count
     *//*

    public int count(DalHints hints) throws SQLException {
        hints = DalHints.createIfAbsent(hints);
        SelectSqlBuilder builder = new SelectSqlBuilder().selectCount();
        return client.count(builder, hints).intValue();
    }

    */
/**
     * Query T with paging function
     * The pageSize and pageNo must be greater than zero.
     *//*

    public List<T> queryAllByPage(int pageNo, int pageSize, DalHints hints) throws SQLException {
        hints = DalHints.createIfAbsent(hints);

        SelectSqlBuilder builder = new SelectSqlBuilder();
        builder.selectAll().atPage(pageNo, pageSize).orderBy("id", ASC);

        return client.query(builder, hints);
    }

    */
/**
     * Get all records from table
     *//*

    public List<T> queryAll(DalHints hints) throws SQLException {
        hints = DalHints.createIfAbsent(hints);

        SelectSqlBuilder builder = new SelectSqlBuilder().selectAll().orderBy("id", ASC);

        return client.query(builder, hints);
    }

    */
/**
     * Insert single pojo
     *
     * @param hints   Additional parameters that instruct how DAL Client perform database operation.
     * @param daoPojo pojo to be inserted
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int insert(DalHints hints, T daoPojo) throws SQLException {
        if (null == daoPojo)
            return 0;
        hints = DalHints.createIfAbsent(hints);
        return client.insert(hints, daoPojo);
    }

    */
/**
     * Insert pojos one by one. If you want to inert them in the batch mode,
     * user batchInsert instead. You can also use the combinedInsert.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database operation.
     *                 DalHintEnum.continueOnError can be used
     *                 to indicate that the inserting can be go on if there is any
     *                 failure.
     * @param daoPojos list of pojos to be inserted
     * @return how many rows been affected
     *//*

    public int[] insert(DalHints hints, List<T> daoPojos) throws SQLException {
        if (null == daoPojos || daoPojos.size() <= 0)
            return new int[0];
        hints = DalHints.createIfAbsent(hints);
        return client.insert(hints, daoPojos);
    }

    */
/**
     * Insert pojo and get the generated PK back in keyHolder.
     * If the "set no count on" for MS SqlServer is set, the operation may fail.
     * Please don't pass keyholder for MS SqlServer to avoid the failure in such case.
     *
     * @param hints     Additional parameters that instruct how DAL Client perform database operation.
     * @param keyHolder holder for generated primary keys
     * @param daoPojo   pojo to be inserted
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int insert(DalHints hints, KeyHolder keyHolder, T daoPojo) throws SQLException {
        if (null == daoPojo)
            return 0;
        hints = DalHints.createIfAbsent(hints);
        return client.insert(hints, keyHolder, daoPojo);
    }

    */
/**
     * Insert pojos and get the generated PK back in keyHolder.
     * If the "set no count on" for MS SqlServer is set, the operation may fail.
     * Please don't pass keyholder for MS SqlServer to avoid the failure in such case.
     *
     * @param hints     Additional parameters that instruct how DAL Client perform database operation.
     *                  DalHintEnum.continueOnError can be used
     *                  to indicate that the inserting can be go on if there is any
     *                  failure.
     * @param keyHolder holder for generated primary keys
     * @param daoPojos  list of pojos to be inserted
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int[] insert(DalHints hints, KeyHolder keyHolder, List<T> daoPojos) throws SQLException {
        if (null == daoPojos || daoPojos.size() <= 0)
            return new int[0];
        hints = DalHints.createIfAbsent(hints);
        return client.insert(hints, keyHolder, daoPojos);
    }

    */
/**
     * Insert pojos in batch mode.
     * The DalDetailResults will be set in hints to allow client know how the operation performed in each of the shard.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database operation.
     * @param daoPojos list of pojos to be inserted
     * @return how many rows been affected for inserting each of the pojo
     * @throws SQLException
     *//*

    public int[] batchInsert(DalHints hints, List<T> daoPojos) throws SQLException {
        if (null == daoPojos || daoPojos.size() <= 0)
            return new int[0];
        hints = DalHints.createIfAbsent(hints);
        return client.batchInsert(hints, daoPojos);
    }

    */
/**
     * Insert multiple pojos in one INSERT SQL
     * The DalDetailResults will be set in hints to allow client know how the operation performed in each of the shard.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database operation.
     * @param daoPojos list of pojos to be inserted
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int combinedInsert(DalHints hints, List<T> daoPojos) throws SQLException {
        if (null == daoPojos || daoPojos.size() <= 0)
            return 0;
        hints = DalHints.createIfAbsent(hints);
        return client.combinedInsert(hints, daoPojos);
    }

    */
/**
     * Insert multiple pojos in one INSERT SQL and get the generated PK back in keyHolder.
     * If the "set no count on" for MS SqlServer is set, the operation may fail.
     * Please don't pass keyholder for MS SqlServer to avoid the failure in such case.
     * The DalDetailResults will be set in hints to allow client know how the operation performed in each of the shard.
     *
     * @param hints     Additional parameters that instruct how DAL Client perform database operation.
     * @param keyHolder holder for generated primary keys
     * @param daoPojos  list of pojos to be inserted
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int combinedInsert(DalHints hints, KeyHolder keyHolder, List<T> daoPojos) throws SQLException {
        if (null == daoPojos || daoPojos.size() <= 0)
            return 0;
        hints = DalHints.createIfAbsent(hints);
        return client.combinedInsert(hints, keyHolder, daoPojos);
    }

    */
/**
     * Delete the given pojo.
     *
     * @param hints   Additional parameters that instruct how DAL Client perform database operation.
     * @param daoPojo pojo to be deleted
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int delete(DalHints hints, T daoPojo) throws SQLException {
        if (null == daoPojo)
            return 0;
        hints = DalHints.createIfAbsent(hints);
        return client.delete(hints, daoPojo);
    }

    */
/**
     * Delete the given pojos list one by one.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database operation.
     * @param daoPojos list of pojos to be deleted
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int[] delete(DalHints hints, List<T> daoPojos) throws SQLException {
        if (null == daoPojos || daoPojos.size() <= 0)
            return new int[0];
        hints = DalHints.createIfAbsent(hints);
        return client.delete(hints, daoPojos);
    }

    */
/**
     * Delete the given pojo list in batch.
     * The DalDetailResults will be set in hints to allow client know how the operation performed in each of the shard.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database operation.
     * @param daoPojos list of pojos to be deleted
     * @return how many rows been affected for deleting each of the pojo
     * @throws SQLException
     *//*

    public int[] batchDelete(DalHints hints, List<T> daoPojos) throws SQLException {
        if (null == daoPojos || daoPojos.size() <= 0)
            return new int[0];
        hints = DalHints.createIfAbsent(hints);
        return client.batchDelete(hints, daoPojos);
    }

    */
/**
     * Update the given pojo . By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param hints   Additional parameters that instruct how DAL Client perform database operation.
     *                DalHintEnum.updateNullField can be used
     *                to indicate that the field of pojo is null value will be update.
     * @param daoPojo pojo to be updated
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int update(DalHints hints, T daoPojo) throws SQLException {
        if (null == daoPojo)
            return 0;
        hints = DalHints.createIfAbsent(hints);
        return client.update(hints, daoPojo);
    }

    */
/**
     * Update the given pojo list one by one. By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database operation.
     *                 DalHintEnum.updateNullField can be used
     *                 to indicate that the field of pojo is null value will be update.
     * @param daoPojos list of pojos to be updated
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int[] update(DalHints hints, List<T> daoPojos) throws SQLException {
        if (null == daoPojos || daoPojos.size() <= 0)
            return new int[0];
        hints = DalHints.createIfAbsent(hints);
        return client.update(hints, daoPojos);
    }

    */
/**
     * Update the given pojo list in batch.
     *
     * @return how many rows been affected
     * @throws SQLException
     *//*

    public int[] batchUpdate(DalHints hints, List<T> daoPojos) throws SQLException {
        if (null == daoPojos || daoPojos.size() <= 0)
            return new int[0];
        hints = DalHints.createIfAbsent(hints);
        return client.batchUpdate(hints, daoPojos);
    }

    public T queryFirst(TableSelectBuilder selectBuilder, DalHints hints) throws SQLException {
        return  client.queryObject((TableSelectBuilder)selectBuilder.requireFirst().nullable(), hints);
    }



    */
/**
     * 查询builder
     *
     * @param whereClause        条件sql
     * @param requireColumnNames 需要查找的列名
     * @param parameters         参数
     * @return
     *//*

    protected BaseTableSelectBuilder selectBuilder(final String whereClause, final String[] requireColumnNames, final StatementParameters parameters) {
        final BaseTableSelectBuilder builder = new BaseTableSelectBuilder();
        builder.select(requireColumnNames)
                .where(whereClause)
                .with(parameters);
        return builder;
    }

}*/
