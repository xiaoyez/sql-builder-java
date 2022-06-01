package com.xy.sql.element;

import com.xy.sql.utils.SqlUtils;
import lombok.val;

/**
 * @author xiaoye
 * @create 2022-05-30 16:16
 */
public class ValueElement implements Element{

    protected Object value;

    protected Class valueType;

    protected String alias;

    protected ValueElement(){}

    public static ValueElement of(Object value)
    {
        return of(value,null);
    }

    /**
     *
     * @param value 值
     * @param alias 别名
     * @return
     */
    public static ValueElement of(Object value,String alias)
    {
        final val valueElement = new ValueElement();
        valueElement.value = value;
        valueElement.valueType = value.getClass();
        valueElement.alias = alias;
        return valueElement;
    }

    public String toSqlString() {
        String sqlString = null;
        if (Number.class.isAssignableFrom(valueType))
            sqlString =  value.toString();
        else if (String.class == valueType)
            sqlString = SqlUtils.toStr((String) value);
        else
            sqlString = value.toString();
        return sqlString + alias == null ? "" : " AS " + SqlUtils.escape(alias);
    }
}
