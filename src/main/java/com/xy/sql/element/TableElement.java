package com.xy.sql.element;

import com.xy.sql.utils.SqlUtils;
import lombok.val;

/**
 * @author xiaoye
 * @create 2022-05-30 17:03
 */
public class TableElement implements Element{

    protected StringBuilder builder = new StringBuilder();

    protected TableElement(){}

    public static TableElement of(String tableName)
    {
        return of(tableName,null);
    }

    public static TableElement of(String tableName,String tableAlias)
    {
        final val tableElement = new TableElement();
        tableElement.builder.append(SqlUtils.escape(tableName)
                                + ((tableAlias == null) ? "" : " AS " + SqlUtils.escape(tableAlias)));
        return tableElement;
    }

    public TableElement leftJoin(TableElement tableElement)
    {
        builder.append(" LEFT JOIN ")
                .append(tableElement.toSqlString());
        return this;
    }

    public TableElement innerJoin(TableElement tableElement)
    {
        builder.append(" INNER JOIN ")
                .append(tableElement.toSqlString());
        return this;
    }

    public TableElement rightJoin(TableElement tableElement)
    {
        builder.append(" RIGHT JOIN ")
                .append(tableElement.toSqlString());
        return this;
    }

    public TableElement on(String conditionStr)
    {
        builder.append(" ON ")
                .append(conditionStr);
        return this;
    }


    @Override
    public String toSqlString() {
        return builder.toString();
    }
}
