package com.xy.sql.utils;

/**
 * @author xiaoye
 * @create 2022-05-30 16:22
 */
public class SqlUtils {

    private static final String
        START_ESCAPE_CHARACTER = "`",
        END_ESCAPE_CHARACTER = "`";

    /**
     * 将str转成sql的字符串(就是拼接单引号)
     * @param str
     * @return
     */
    public static String toStr(String str)
    {
        if (str.startsWith("'") && str.endsWith("'"))
            return str;
        return "'" + str + "'";
    }

    /**
     * 将str转义,防止sql将其当做关键字引发bug
     * @param str
     * @return
     */
    public static String escape(String str) {
        if (str.startsWith(START_ESCAPE_CHARACTER) && str.endsWith(END_ESCAPE_CHARACTER))
            return str;
        else
            return START_ESCAPE_CHARACTER + str + END_ESCAPE_CHARACTER;
    }
}
