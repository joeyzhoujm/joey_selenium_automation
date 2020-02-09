/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: Person
 * Author:   Joey
 * Date:     1/7/2020 10:55 PM
 * Description: 测试用的demo
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/7/2020 10:55 PM        1.0          测试用的demo
 */
package com.joey.auto.test.po.excelobject;

/**
 * 〈功能简述〉<br>
 * 〈测试用的demo〉
 *
 * @author Joey
 * @create 1/7/2020
 * @since 1.0.0
 */

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class Person {

    @Excel(name = "姓名", orderNum = "0")
    private String name;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "1")
    private String sex;

    @Excel(name = "生日", exportFormat = "yyyy-MM-dd", orderNum = "2")
    private Date birthday;

    public Person(String name, String sex, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
