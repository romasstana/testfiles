package com.example.demo;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class XLSFileReader {
    String XLSFilePath = "C:\\Users\\rualdinuly\\IdeaProjects\\fileTest\\demo\\src\\test\\resourcesfile_example_XLS_50.xls";
    @Test
    public void canAssertThatXlsContainsText() throws IOException {

        XLS spreadsheet = new XLS(new File(XLSFilePath));
        assertTrue(spreadsheet.excel.getSheetAt(0).getRow(13).getCell(0).toString().equals("13.0"));
        assertTrue(spreadsheet.excel.getSheetAt(0).getRow(13).getCell(1).toString().equals("Sherron"));
        assertTrue(spreadsheet.excel.getSheetAt(0).getRow(13).getCell(2).toString().equals("Ascencio"));
        assertTrue(spreadsheet.excel.getSheetAt(0).getRow(13).getCell(3).toString().equals("Female"));
        assertTrue(spreadsheet.excel.getSheetAt(0).getRow(13).getCell(4).toString().equals("Great Britain"));
        assertTrue(spreadsheet.excel.getSheetAt(0).getRow(13).getCell(5).toString().equals("32.0"));
        assertTrue(spreadsheet.excel.getSheetAt(0).getRow(13).getCell(6).toString().equals("16/08/2016"));
        assertTrue(spreadsheet.excel.getSheetAt(0).getRow(13).getCell(7).toString().equals("3256.0"));
    }
    @Test
    public void canAssertThatXlsHasSpecificNumberOfRows() {
        XLS spreadsheet = new XLS(new File(XLSFilePath));
        assertTrue(spreadsheet.excel.getSheetAt(0).getPhysicalNumberOfRows() == 51);
    }
}
