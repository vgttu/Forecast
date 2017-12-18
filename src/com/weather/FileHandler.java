package com.weather;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir Gaidushin on 10.12.2017.
 */
public class FileHandler {
    protected boolean mock = false;
    protected List<String> mockStrings = new ArrayList<>();

    public FileHandler() {
    }

    public FileHandler(boolean mock) {
        this.mock = mock;
    }

    public List<String> read(String file) throws IOException {
        List<String> lines = new ArrayList<>();

        if (! this.isMock()) {
            Path path = Paths.get(file);

            lines = Files.readAllLines(path);
        } else {
            lines = this.mockStrings;
        }

        return lines;
    }

    public boolean write(List<String> lines, String file) throws IOException {
        if (! this.isMock()) {
            Path path = Paths.get(file);

            Files.write(path, lines, StandardCharsets.UTF_8);
        } else {
            this.mockStrings = lines;
        }

        return true;
    }

    public boolean delete(String file) throws IOException {
        if (! this.isMock()) {
            Path path = Paths.get(file);

            Files.delete(path);
        }

        return true;
    }

    public boolean isMock() {
        return mock;
    }

    public static FileHandler mock() {
        return new FileHandler(true);
    }
}
