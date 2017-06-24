package com.vinci.mybatisLearn.utils;

import com.relops.snowflake.Snowflake;

/**
 * Created by Jao on 2017/6/22.
 */
public class SnowflakeUtil {
    private final static Snowflake SNOWFLAKE = new Snowflake(1);

    public static long next() {
        return SNOWFLAKE.next();
    }
}
