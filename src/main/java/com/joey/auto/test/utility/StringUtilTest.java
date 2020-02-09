/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: StringUtilTest
 * Author:   Joey
 * Date:     1/20/2020 8:27 PM
 * Description: 测试String
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/20/2020 8:27 PM        1.0          测试String
 */
package com.joey.auto.test.utility;

//import org.apache.commons.lang3.StringUtils;

//import com.alibaba.excel.util.StringUtils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 〈功能简述〉<br>
 * 〈测试String〉
 *
 * @author Joey
 * @create 1/20/2020
 * @since 1.0.0
 */
public class StringUtilTest {

    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty("a"));


        SimpleDateFormat sdf = new SimpleDateFormat("'yyyy-MM-dd'");
        try {
            sdf.parse("20200120");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}