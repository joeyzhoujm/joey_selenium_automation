/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: Demo
 * Author:   Joey
 * Date:     1/13/2020 10:15 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/13/2020 10:15 PM        1.0
 */
package com.joey.auto.test.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Joey
 * @create 1/13/2020
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("a", "b"));
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("a", "b", "c"));


        System.out.println(Collections.disjoint(list1, list2));
        System.out.println(!Collections.disjoint(list1, list2));
        System.out.println(list2.contains("a"));


    }

}