package com.xy.sql.element;

import com.xy.sql.utils.SqlUtils;
import lombok.val;

/**
 * @author xiaoye
 * @create 2022-05-30 16:27
 */
public class ColumnElement extends ValueElement{

    public static ColumnElement of(String colName)
    {
        return ColumnElement.of(colName,null);
    }

    public static ColumnElement of(String colName, String alias)
    {
        final val columnElement = new ColumnElement();
        columnElement.value = colName;
        columnElement.valueType = String.class;
        columnElement.alias = alias;
        return columnElement;
    }

    @Override
    public String toSqlString() {
        String sqlString = null;
        String valueStr = (String) value;
        if (valueStr.contains("."))
        {
            final val split = valueStr.split("\\.");
            String table = split[0];
            String col = split[1];
            sqlString = SqlUtils.escape(table) + "." + SqlUtils.escape(col);
        }
        else
            sqlString = SqlUtils.escape((String)value);
        return sqlString + (alias == null ? "" : " AS " + SqlUtils.escape(alias));
    }
}
