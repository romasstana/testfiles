package com.example.demo;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.xlstest.XLS.containsText;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class FileParserTest {
    ClassLoader classLoader = FileParserTest.class.getClassLoader();
    static String zipFileName = "C:\\Users\\rualdinuly\\IdeaProjects\\fileTest\\demo\\src\\test\\resources\\files.zip";
    String pdfFileName = "sample.pdf";
    String csvFileName = "file_example_CSV_5000.csv";
    String xlsFileName = "file_example_XLS_50.xls";
    static String OUTPUT_DIR = "C:\\Users\\rualdinuly\\IdeaProjects\\fileTest\\demo\\src\\test\\resources";
    static final int BUFFER_SIZE = 8192;
    private static void readUsingZipInputStream() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(zipFileName));
        final ZipInputStream is = new ZipInputStream(bis); try { ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                System.out.printf("File: %s Size %d Modified on %TD %n", entry.getName(), entry.getSize(), new Date(entry.getTime()));
                extractEntry(entry, is);
            }
        } finally {
            is.close();
        }
    }
    private static void extractEntry(final ZipEntry entry, InputStream is) throws IOException {
        String exractedFile = OUTPUT_DIR + entry.getName();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(exractedFile);
            final byte[] buf = new byte[BUFFER_SIZE];
            int read = 0;
            int length;
            while ((length = is.read(buf, 0, buf.length)) >= 0) {
                fos.write(buf, 0, length);
            }
        } catch (IOException ioex)
        {
            fos.close();
        }
    }


    @Test
    @Order(1)
    public void canAssertThatPdfContainsText() throws IOException {
        readUsingZipInputStream();
        PDF pdf = new PDF(new File("C:\\Users\\rualdinuly\\IdeaProjects\\fileTest\\demo\\src\\test\\resourcessample.pdf"));
        assertThat(pdf).containsExactText("A Simple PDF File");
    }

}
