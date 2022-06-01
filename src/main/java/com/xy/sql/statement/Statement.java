package com.xy.sql.statement;

/**
 * Sql语句对象
 * @author xiaoye
 * @create 2022-05-30 16:05
 */
public class Statement {

    private StringBuilder builder;

    public Statement(StringBuilder builder) {
        this.builder = builder;
    }

    /**
     * 转成sql语句字符串
     * @return
     */
    public String toSqlString()
    {
        return builder.toString();
    }
}
