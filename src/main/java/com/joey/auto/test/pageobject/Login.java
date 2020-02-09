package com.joey.auto.test.pageobject;

import com.joey.auto.test.module.Brower;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;

    public void init() {
        String url = "https://www.smzdm.com/";

        //新建一个浏览器句柄
        driver = new Brower().Chrome();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.manage().getCookies());

        Cookie c1 = new Cookie("__ckguid", "P6Ay4xkqurhhlrQKkxOVq3");
        Cookie c2 = new Cookie("device_id", "184902870315718300685032522bb16a634d4f51dfa2554a0e95d0250d");
        Cookie c3 = new Cookie("zdm_qd", "%7B%7D");
        Cookie c4 = new Cookie("_ga", "GA1.2.1956280537.1571830070");
        Cookie c5 = new Cookie("_gid", "GA1.2.582414174.1571830070");
        Cookie c6 = new Cookie("homepage_sug", "i");
        Cookie c7 = new Cookie("r_sort_type", "score");
        Cookie c8 = new Cookie("__jsluid_s", "907c73ce03bb5c921e56eb0d2331a91a");
        Cookie c9 = new Cookie("userId", "marsjoey|6868178412");
        Cookie c10 = new Cookie("__gads", "ID=402ef70a3d0f7ff6:T=1571832342:S=ALNI_Mahd5c8Dq8vfqEcgYyxZlyv7vcA6Q");
        Cookie c11 = new Cookie("smzdm_user_source", "B60DF8D157B86CE240F9A426742C7683");
        Cookie c12 = new Cookie("s_his", "%E4%B9%8C%E9%B8%A1%E7%99%BD%E5%87%A4%E4%B8%B8%E5%91%A2");
        Cookie c13 = new Cookie("ss_ab", "ss9");
        Cookie c14 = new Cookie("PHPSESSID", "30256f2f805a13ee0d22b7644e34827b");
        Cookie c15 = new Cookie("_zdmA.vid", "*");
        Cookie c16 = new Cookie("Hm_lvt_9b7ac3d38f30fe89ff0b8a0546904e58", "1571832343,1571878779");
        Cookie c17 = new Cookie("ad_date", "24");
        Cookie c18 = new Cookie("ad_json_feed", "%7B%22J_feed_ad1%22%3A%7B%22number%22%3A0%2C%22surplus%22%3A4%7D%7D");
        Cookie c19 = new Cookie("bannerCounter", "%5B%7B%22number%22%3A0%2C%22surplus%22%3A1%7D%2C%7B%22number%22%3A0%2C%22surplus%22%3A4%7D%2C%7B%22number%22%3A1%2C%22surplus%22%3A1%7D%2C%7B%22number%22%3A0%2C%22surplus%22%3A1%7D%2C%7B%22number%22%3A0%2C%22surplus%22%3A1%7D%2C%7B%22number%22%3A0%2C%22surplus%22%3A1%7D%5D");
        Cookie c20 = new Cookie("user", "marsjoey%7C6868178412");
        Cookie c21 = new Cookie("smzdm_id", "6868178412");
        Cookie c22 = new Cookie("amvid", "17334e58f57838963aa5685b020d23e8");
        Cookie c23 = new Cookie("_gat_UA-27058866-1", "1");
        Cookie c24 = new Cookie("sess", "ZmUxY2R8MTU3NzA2MzA3MHw2ODY4MTc4NDEyfDFmOGExMDc3MzkzOGUyZDU3ZWFmNGQ5OWNkOGM4OTRj");
        Cookie c25 = new Cookie("_zdmA.time", "1571879073558.7928.https%3A%2F%2Fwww.smzdm.com%2F");
        Cookie c26 = new Cookie("_zdmA.uid", "ZDMA._Ah-wmPcx.1571879074.2419200");
        Cookie c27 = new Cookie("Hm_lpvt_9b7ac3d38f30fe89ff0b8a0546904e58", "1571879074");

        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);
        driver.manage().addCookie(c3);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
