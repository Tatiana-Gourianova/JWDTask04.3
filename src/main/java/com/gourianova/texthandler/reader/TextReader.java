package com.gourianova.texthandler.reader;

import com.gourianova.texthandler.exception.InitializationException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {

    public String readText(String path) throws InitializationException {
        StringBuilder text = new StringBuilder();
        try {
            Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8).forEach(str -> text.append(str).append("\n"));
        } catch (IOException e) {
            throw new InitializationException("Ошибка с файлом" + e.getMessage());
        }
        return text.toString();
    }
}
