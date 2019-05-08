package com.zking.component;

import org.springframework.stereotype.Component;

/**
 * @author chendesheng
 */
@Component
public class StringAndArray {
    
    /**
     * 字符串转换成字符串数组
     * @param str 字符串
     * @return 转换后的字符串数组
     */
    public static String[] stringToArray(String str){
        String[] array = str.split(",");
        return array;
    }

    /**
     * 字符串数组拼接成字符串
     * @param articleTags 字符串数组
     * @return 拼接后的字符串
     */
    public static String arrayToString(String[] articleTags){
        String buffered = "";
        for(String s : articleTags){
            if("".equals(buffered)){
                buffered +=  s;
            } else {
                buffered += "," + s;
            }
        }
        return buffered;
    }

}
