package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class JsonFileTest {
    @Test
    public void canAssertThatJsonHasCorrectData() throws IOException {
        String JsonFilePath = "C:\\Users\\rualdinuly\\IdeaProjects\\fileTest\\demo\\src\\test\\resources\\game.json";
        ObjectMapper mapper = new ObjectMapper();
        Heralt heralt = mapper.readValue(Paths.get(JsonFilePath).toFile(), Heralt.class);

        assertThat(heralt.getName().equals("Witcher"));
        assertEquals(heralt.isAvailable(), true);
        assertEquals(heralt.getPrice(), 132);
        assertEquals(heralt.getVersion(), 3.0);
        assertTrue(Arrays.stream(heralt.getFunctions()).toList().equals(Arrays.stream((new String[] {"buy","setup","update","delete", "open", "close"})).toList()));
    }
}
