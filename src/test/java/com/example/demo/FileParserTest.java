package com.example.demo;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class FileParserTest {
    ClassLoader classLoader = FileParserTest.class.getClassLoader();
    String zipFileName = "files.zip";
    String pdfFileName = "sample.pdf";
    String csvFileName = "file_example_CSV_5000.csv";
    String xlsFileName = "file_example_XLS_50.xls";
    @Test
    public void canAssertThatPdfContainsText() throws IOException {
        PDF pdf = new PDF(new File("src/test/resources/50quickideas.pdf"));
        assertThat(pdf).containsExactText("A Simple PDF File");
    }
}
