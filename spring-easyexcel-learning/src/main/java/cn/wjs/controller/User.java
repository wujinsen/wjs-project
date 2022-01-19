package cn.wjs.controller;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class User {

    @ExcelProperty(value="姓名", index = 0)
    private String name;

    @ExcelProperty(value="年龄", index = 1)
    private int age;
    @ExcelIgnore
    private String abc;
}
