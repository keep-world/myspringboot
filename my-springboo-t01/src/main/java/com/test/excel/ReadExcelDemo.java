package com.test.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.List;

public class ReadExcelDemo {

    public static void main(String[] args) {
        String fileName = "data.xlsx";  // Excel文件名

        // 读取Excel文件
        EasyExcel.read(fileName, new ReadListener())
                .sheet()  // 读取第一个Sheet
                .doRead();
    }

    static class ReadListener extends AnalysisEventListener<List<String>> {

        @Override
        public void invoke(List<String> rowData, AnalysisContext context) {
            // 处理每一行数据
            System.out.println(rowData);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            System.out.println("读取完毕");
        }
    }
}
