package com.ksf.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String directory = args[0];
        try {
            List<Path> list = Files.find(Paths.get(directory),999,(p, bfa) -> bfa.isRegularFile()).collect(Collectors.toList());
            list.forEach(System.out::println);
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
    }
}
