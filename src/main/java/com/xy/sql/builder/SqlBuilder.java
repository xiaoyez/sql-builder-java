package com.xy.sql.builder;

/**
 * @author xiaoye
 * @create 2022-05-30 16:05
 */
public class SqlBuilder {

    public static SelectSqlBuilder buildSelect()
    {
        return new SelectSqlBuilder();
    }
}
