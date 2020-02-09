/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: FileUtil
 * Author:   Joey
 * Date:     1/7/2020 11:30 PM
 * Description: 文件操作類
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/7/2020 11:30 PM        1.0          文件操作類
 */
package com.joey.auto.test.utility;

import java.io.IOException;

/**
 * 〈功能简述〉<br>
 * 〈文件操作類〉
 *
 * @author Joey
 * @create 1/7/2020
 * @since 1.0.0
 */
public class FileUtil<T> {

  /*  // 挂在项目的某文件夹下
    public static final String REPORT_PATH ="template"+ File.separator;


    *//**
     * 导出数据
     * @auther xuguocai
     * @param fileName 文件名
     * @param titles  字段名
     * @param result 导出数据
     * @throws IOException
     *//*
    public static String exportExcel(String fileName, String[] titles, List<Map<String,Object>> result) throws IOException {
        *//*HSSFWorkbook workbook;
        FileOutputStream fileOutputStream;
        String tempName = fileName;
        try {
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            fileName +="_"+df.format(date)+".xls";

            fileOutputStream = new FileOutputStream(FileUtil.REPORT_PATH + fileName);
            workbook= new HSSFWorkbook();

            HSSFSheet sheet = workbook.createSheet();

            // 设置列宽
            for(int i = 0; i < titles.length-1; i++){
                sheet.setColumnWidth( i, 256*15+184);
            }

            // 第一行表头标题，CellRangeAddress 参数：行 ,行, 列,列
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(new HSSFRichTextString(tempName));
            cell.setCellStyle(fontStyle(workbook));
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,titles.length-1));

            // 第二行
            HSSFRow row3 = sheet.createRow(1);

            // 第二行的列
            for(int i=0; i < titles.length; i++){
                cell = row3.createCell(i);
                cell.setCellValue(new HSSFRichTextString(titles[i]));
                cell.setCellStyle(fontStyle(workbook));
            }

            //填充数据的内容  i表示行，z表示数据库某表的数据大小，这里使用它作为遍历条件
            int i = 2, z = 0;
            while (z < result.size()) {
                row = sheet.createRow(i);
                Map<String,Object> map = result.get(z);
                for(int j=0;j < titles.length;j++) {
                    cell = row.createCell(j);
                    if(map.get(titles[j]) !=null) {
                        cell.setCellValue(map.get(titles[j]).toString());
                    }else {
                        cell.setCellValue("");
                    }
                }
                i++;
                z++;
            }

            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return FileUtil.REPORT_PATH + fileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }*/

}
