package com.itheima.common.utils;

import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
  * 简单的工具类，用户小程序使用
  *
  * @author: qinjie
 **/
public class CommonUtils {
    /**
     *
     * 功能描述: 得到当前时间
     *
     * @return: 当前时间，2017-08-08.。。。
     * @auther: 秦杰
     * @date: 2019/8/29 11:39
     */
    public static String getCurrentTime(){
       return TimeStampToTime(System.currentTimeMillis());
}
   /**
    *
    * 功能描述: 向右补位
    *
    * @param: src原字符串，len补位后的总的长度，ch补位字符
    * @return:
    * @auther: 秦杰
    * @date: 2019/8/29 11:41
    */
    public static String padRight(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }
    /**
     *
     * 功能描述: 向左边补位
     *
     * @param: [src, len, ch] src：原字符串   len：补足的长度，  ch：补位的字符
     * @return: java.lang.String
     * @auther: 秦杰
     */
    public static String padLeft(String src, int len, char ch) {

        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    /**
     *
     * 功能描述: 得到指定长度的随机字符串，存在重复的可能性
     *
     * @param: [length]生成随机字符串的长度
     * @return: java.lang.String
     * @auther: 秦杰
     */
    public static String getRandomString(int length) { //length表示生成字符串的长度

        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    /**
     *
     * 功能描述: 得到头部保存的信息，token信息
     *
     * @param: [attributes]
     * @return: java.lang.String
     * @auther: 秦杰
     */
    public static String getHeadToken(ServletRequestAttributes attributes, String key) {

        HttpServletRequest request = attributes.getRequest();
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key1 = (String) headerNames.nextElement();
            String value = request.getHeader(key1);
            map.put(key1, value);
        }
        return map.get(key);
    }

    /**
     *
     * 功能描述: 判断是否位手机号
     *
     * @param: [str]字符串
     * @return: boolean
     * @auther: 秦杰
     * @date: 2019/7/27 16:13
     */
    public static boolean isPhone(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(1[3,4,5,7,8][0-9])\\d{8}$");
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        return b;
    }
    /**
     *
     * 功能描述: Date转换成定时器中Cron表达式
     *
     * @param: [time]Date类型的时间
     * @return: java.lang.String
     * @auther: 秦杰
     */
    public static String getCron(Long time) {

        String dateFormat = "ss mm HH dd MM ? yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (time != null) {
            formatTimeStr = sdf.format(time);
        }
        return formatTimeStr;
    }
    /**
     *
     * 功能描述: 得到当前时间
     *
     * @return: 时间的字符串，20170810
     * @auther: 秦杰
     */
    public static String getDateTime(){
        String strDate = "";
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            strDate = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }



    public static void main(String args[]){
        Integer a = 1;
        HashMap res = new HashMap();
        res.put("a", a);
        Object o = res.get(a);
        System.out.println(o);
        System.out.println((Integer)o);
        System.out.println((String)o);

    }
    public static String TimeStampToTime(Long t){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(Long.parseLong(String.valueOf(t))));      // 时间戳转换成时间
    }
    public static void sortByAsc(Integer num[]){
        for(int i = 0; i < num.length-1; i++){
            for (int j = i+1; j < num.length; j++){
                if(num[i] > num[j]){
                    int a = num[i];
                    num[i] = num[j];
                    num[j] = a;
                }
            }
        }
    }
    /**
     * @Description: 正则表达式判断字符串是否是数字
     * @Param: [str]
     * @return: boolean
     * @Author: YJC
     * @Date: 2019/11/30
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    /**
     * 过滤请求报文中的空字符串或者空字符串
     * @param contentData
     * @return
     */
    public static Map<String, String> filterBlank(Map<String, String> contentData){
        Map<String, String> submitFromData = new HashMap<String, String>();
        Set<String> keyset = contentData.keySet();

        for(String key:keyset){
            String value = contentData.get(key);
            if (value != null && !"".equals(value.trim())) {
                // 对value值进行去除前后空处理
                submitFromData.put(key, value.trim());
            }
        }
        return submitFromData;
    }

    /**
     * 功能描述: 返回其中保存的地址中参数通过Map返回
     * @param request 请求对象的HttpServletRequest
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    public static Map<String, String> getAllRequestParam(
            final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                // 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
                if (res.get(en) == null || "".equals(res.get(en))) {
                    // System.out.println("======为空的字段名===="+en);
                    res.remove(en);
                }
            }
        }
        return res;
    }


}
