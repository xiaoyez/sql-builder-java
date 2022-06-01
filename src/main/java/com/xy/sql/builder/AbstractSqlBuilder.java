package com.xy.sql.builder;

import com.xy.sql.statement.Statement;

/**
 * @author xiaoye
 * @create 2022-05-30 16:07
 */
public abstract class AbstractSqlBuilder implements ISqlBuilder{

    protected StringBuilder builder = new StringBuilder();

    public Statement build() {
        return new Statement(new StringBuilder(builder.toString()));
    }
}
