package com.xy.sql.builder;

import com.xy.sql.element.ColumnElement;
import com.xy.sql.element.TableElement;
import com.xy.sql.element.ValueElement;
import com.xy.sql.utils.SqlUtils;

import java.util.Arrays;
import java.util.Collection;

/**
 * 构建select语句
 * @author xiaoye
 * @create 2022-05-30 16:10
 */
public class SelectSqlBuilder extends AbstractSqlBuilder{

    public SelectSqlBuilder select(String sqlStr)
    {
        builder.append("SELECT ")
                .append(sqlStr);
        return this;
    }

    public SelectSqlBuilder select(ValueElement element)
    {
        builder.append("SELECT ")
                .append(element.toSqlString());
        return this;
    }

    public SelectSqlBuilder select(ValueElement... elements)
    {
        builder.append("SELECT ");
        Arrays.stream(elements)
                .forEach(e -> builder.append(e.toSqlString())
                                    .append(","));
        builder.deleteCharAt(builder.length() - 1);
        return this;
    }

    public SelectSqlBuilder select(Collection<ValueElement> elements)
    {
        builder.append("SELECT ");
        elements.forEach(e -> builder.append(e.toSqlString())
                        .append(","));
        builder.deleteCharAt(builder.length() - 1);
        return this;
    }

    public SelectSqlBuilder from(String tableSqlStr)
    {
        builder.append(" FROM ")
                .append(SqlUtils.escape(tableSqlStr));
        return this;
    }

    public SelectSqlBuilder from(String... tablesSqlStr)
    {
        builder.append(" FROM ");
        Arrays.stream(tablesSqlStr)
                .forEach(table -> builder.append(SqlUtils.escape(table) + ","));
        builder.deleteCharAt(builder.length() - 1);
        return this;
    }

    public SelectSqlBuilder from(TableElement tableElement)
    {
        builder.append(" FROM ")
                .append(tableElement.toSqlString());
        return this;
    }

    public SelectSqlBuilder from(TableElement... tableElements)
    {
        builder.append(" FROM ");
        Arrays.stream(tableElements)
                .forEach(table -> builder.append(table.toSqlString() + ","));
        builder.deleteCharAt(builder.length() - 1);
        return this;
    }

    public SelectSqlBuilder where(String conditionStr)
    {
        builder.append(" WHERE ")
                .append(conditionStr);
        return this;
    }

    public SelectSqlBuilder orderBy(String orderDirect,String... columns)
    {
        builder.append(" ORDER BY ");
        Arrays.stream(columns)
                .forEach(column -> builder.append(ColumnElement.of(column).toSqlString()).append(","));
        builder.deleteCharAt(builder.length() - 1);
        if (orderDirect != null)
            builder.append(" " + orderDirect);
        return this;
    }

    public SelectSqlBuilder groupBy(String... columns)
    {
        builder.append(" GROUP BY ");
        Arrays.stream(columns)
                .forEach(column -> builder.append(ColumnElement.of(column).toSqlString()).append(","));
        builder.deleteCharAt(builder.length() - 1);

        return this;
    }

    public SelectSqlBuilder having(String conditionStr)
    {
        builder.append(" HAVING ")
                .append(conditionStr);
        return this;
    }

    public SelectSqlBuilder append(String sql)
    {
        builder.append(" " + sql);
        return this;
    }

}
