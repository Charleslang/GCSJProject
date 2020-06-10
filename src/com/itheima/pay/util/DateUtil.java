package com.itheima.pay.util;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

import static org.apache.http.client.utils.DateUtils.formatDate;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-10
 **/
public class DateUtil extends DateUtils {

    private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
}
