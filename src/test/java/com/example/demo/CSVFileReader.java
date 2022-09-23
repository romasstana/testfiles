package com.example.demo;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CSVFileReader {
    @Test
    public void canAssertThatCSVContainsData() throws IOException {
        String CSVFilePath = "C:\\Users\\rualdinuly\\IdeaProjects\\fileTest\\demo\\src\\test\\resourcesfile_example_CSV_5000.csv";
        CSVReader reader = new CSVReader(new FileReader(CSVFilePath));
        assertThat(reader).contains(new String[]{"1", "Dulce", "Abril", "Female", "United States", "32", "15/10/2017", "1562"});
    }
}
