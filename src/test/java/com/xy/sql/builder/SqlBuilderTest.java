package com.xy.sql.builder;

import com.xy.sql.element.ColumnElement;
import com.xy.sql.element.TableElement;
import com.xy.sql.element.ValueElement;
import lombok.val;
import org.junit.Test;

/**
 * @author xiaoye
 * @create 2022-05-30 16:24
 */
public class SqlBuilderTest {

    @Test
    public void testSelectValue()
    {
        final val sqlString = SqlBuilder.buildSelect()
                .select(ValueElement.of(1))
                .build()
                .toSqlString();

        System.out.println(sqlString);
    }

    @Test
    public void testSelectColumns()
    {
        final val sqlString = SqlBuilder.buildSelect()
                .select(ColumnElement.of("id"),
                        ColumnElement.of("id","stu_id"),
                        ColumnElement.of("student.id"),
                        ColumnElement.of("student.id", "stu_id"))
                .build()
                .toSqlString();

        System.out.println(sqlString);
    }

    @Test
    public void testSelectColumnsFrom()
    {
        final val sqlString = SqlBuilder.buildSelect()
                .select(ColumnElement.of("id"),
                        ColumnElement.of("id","stu_id"),
                        ColumnElement.of("student.id"),
                        ColumnElement.of("student.id", "stu_id"))
                .from("student")
                .build()
                .toSqlString();

        System.out.println(sqlString);
    }

    @Test
    public void testSelectTableElement()
    {
        final val table = TableElement.of("student", "s")
                .innerJoin(TableElement.of("student_score", "ss"))
                .on("s.id = ss.stu_id");
        final val sqlString = SqlBuilder.buildSelect()
                .select("1")
                .from(table)
                .build()
                .toSqlString();
        System.out.println(sqlString);
    }
}
