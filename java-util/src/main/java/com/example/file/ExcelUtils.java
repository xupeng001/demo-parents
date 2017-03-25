package com.example.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 类ExcelUtils.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月25日 上午10:46:13
 */
public class ExcelUtils {

    /**
     * 将excel文件装成List数组
     * 
     * @param is
     * @return
     */
    public static List<List<String>> readExcel(InputStream is) {
        List<List<String>> datas = new ArrayList<List<String>>();
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(is);
        } catch (Exception e) {
            try {
                workbook = new HSSFWorkbook(is);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        if (workbook == null) {
            return datas;
        }
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            Sheet sheet = workbook.getSheetAt(numSheet);
            if (sheet == null) {
                continue;
            }
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row == null) {
                    continue;
                }
                List<String> arrCell = new ArrayList<String>();
                for (int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    if (cell == null) {
                        continue;
                    }
                    arrCell.add(getValue(cell).trim());
                }
                datas.add(arrCell);
            }
        }
        return datas;
    }

    public static void writeExcel(List<List<String>> datas, OutputStream out) {
        // 创建Excel的工作书册 Workbook,对应到一个excel文档  
        HSSFWorkbook wb = new HSSFWorkbook();

        // 创建Excel的工作sheet,对应到一个excel文档的tab  
        HSSFSheet sheet = wb.createSheet("sheet1");

        // 创建字体样式  
        HSSFFont font = wb.createFont();
        font.setFontName("Verdana");
        font.setBoldweight((short) 100);
        font.setFontHeight((short) 300);
        font.setColor(HSSFColor.BLUE.index);

        // 创建单元格样式  
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        // 设置边框  
        style.setBottomBorderColor(HSSFColor.RED.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setFont(font);// 设置字体 

        int rowIndex = 0;
        for (List<String> data : datas) {
            // 创建Excel的sheet的一行 
            HSSFRow row = sheet.createRow(rowIndex);
            row.setHeight((short) 500);// 设定行的高度  
            int cellIndex = 0;
            for (String v : data) {
                // 创建一个Excel的单元格  
                HSSFCell cell = row.createCell(cellIndex);
                // 给Excel的单元格设置样式和赋值  
                cell.setCellStyle(style);
                cell.setCellValue(v);
                cellIndex++;
            }
            rowIndex++;
        }

        try {
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getValue(Cell cell) {
        String result = null;
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            result = String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            result = String.valueOf(cell.getNumericCellValue());
        } else {
            result = String.valueOf(cell.getStringCellValue());
        }
        return result == null ? "" : result;
    }

}
