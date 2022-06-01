package com.xy.sql.element;

/**
 * 元素，相当于sql语句里的一个表达式
 * @author xiaoye
 * @create 2022-05-30 16:16
 */
public interface Element {

    String toSqlString();
}
