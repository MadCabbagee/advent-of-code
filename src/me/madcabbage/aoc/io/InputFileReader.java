package me.madcabbage.aoc.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

class InputReadLineException extends RuntimeException {
    public InputReadLineException(String message) {
        super(message);
    }
}
public class InputFileReader<T> {

    private final Path inputPath;
    public InputFileReader(Path inputFilePath) {
        this.inputPath = inputFilePath;
    }

    public List<T> readToList(Function<String, T> mapper) {
        List<T> inputList = new ArrayList<>();

        try (var br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(InputFileReader.class.getClassLoader().getResourceAsStream(inputPath.toString()))))) {
            String line;
            while ((line = br.readLine()) != null) {
                T mappedLine = mapper.apply(line);
                inputList.add(mappedLine);
            }
        } catch (IOException e) {
            throw new InputReadLineException("Error while reading lines from input file.");
        }

        return inputList;
    }
}
