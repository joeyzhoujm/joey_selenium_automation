/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: IndicatorResultOperation
 * Author:   Joey
 * Date:     1/7/2020 11:27 PM
 * Description: Operate IndicatorResult
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/7/2020 11:27 PM        1.0          Operate IndicatorResult
 */
package com.joey.auto.test.po.excelobject;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈Operate IndicatorResult〉
 *
 * @author Joey
 * @create 1/7/2020
 * @since 1.0.0
 */
public class IndicatorResultOperation {

    public static void createIndicatorResult() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            map.put("topbarMenuName", "异常监控");
            map.put("leftMenuName", "待派工单");
            map.put("leftMidMenuName", "营业管理");
            map.put("menuTitleName", "抄核");
            map.put("indicatorLinkName", "未分配抄表段用户" + i);
            list.add(map);
        }
        for (Map<String, String> li : list) {
            System.out.println(li);
            System.out.println(li.get("topbarMenuName"));
            System.out.println(li.get("leftMenuName"));
        }

        //方法一：通过得到key的值，然后获取value;
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "  " + value);
        }

        //使用迭代器，获取key;
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String value = map.get(key);
            System.out.println(key + " " + value);

            //通过map.entrySet()方法
            //方法一：循环map里面的每一对键值对，然后获取key和value
            for (Map.Entry<String, String> vo : map.entrySet()) {
                vo.getKey();
                vo.getValue();
                System.out.println(vo.getKey() + "  " + vo.getValue());
            }

            //使用迭代器，获取key
            Iterator<Map.Entry<String, String>> iter1 = map.entrySet().iterator();
            while (iter1.hasNext()) {
                Map.Entry<String, String> entry = iter1.next();
                key = entry.getKey();
                value = entry.getValue();
                System.out.println(key + " " + value);
            }

            //将map<String,String> 转化为ArryList,但list里面的元素为Entry<String,String>
            List<Map.Entry<String, String>> list1 = new ArrayList<Map.Entry<String, String>>(map.entrySet());
            //通过匿名比较器的方式进行比较。
            Collections.sort(list1, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1,
                                   Map.Entry<String, String> o2) {
                    int flag = o1.getValue().compareTo(o2.getValue());
                    if (flag == 0) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return flag;
                }
            });
            //遍历list得到map里面排序后的元素
            for (Map.Entry<String, String> en : list1) {
                System.out.println(en.getKey() + " " + en.getValue());
            }
        }
    }


    public static void main(String[] args) {
        createIndicatorResult();
    }

    /*  　*//**
     　　* 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     　　* @param params 需要排序并参与字符拼接的参数组
     　　* @return 拼接后字符串
     　　* @throws UnsupportedEncodingException
     　　*//*

    public static String createLinkStringByGet(Map<String, String> params) throws UnsupportedEncodingException {
　　　　List<String> keys = new ArrayList<String>(params.keySet());
　　　　Collections.sort(keys);
　　　　String prestr = "";
　　　　for (int i = 0; i < keys.size(); i++) {
　　　　　　String key = keys.get(i);
　　　　　　String value = params.get(key);
　　　　　　value = URLEncoder.encode(value, "UTF-8");
　　　　　　if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
　　　　　　　　prestr = prestr + key + "=" + value;
　　　　　　} else {
　　　　　　　　prestr = prestr + key + "=" + value + "&";
　　　　　　}
　　　　}
　　　　return prestr;
　　}*/




    /*@RequestMapping("export")
    public void export(List<Map<String,Object>> indicatorResult){

        //模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("路飞","1",new Date());
        Person person2 = new Person("娜美","2", DateUtils.addDate(new Date(),3));
        Person person3 = new Person("索隆","1", DateUtils.addDate(new Date(),10));
        Person person4 = new Person("小狸猫","1", DateUtils.addDate(new Date(),-10));
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        //导出操作
        FileUtil.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xls",response);
    }

    @RequestMapping("importExcel")
    public void importExcel(){
        String filePath = "F:\\海贼王.xls";
        //解析excel，
        List<Person> personList = FileUtil.importExcel(filePath,1,1,Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");

        //TODO 保存数据库
    }*/

}