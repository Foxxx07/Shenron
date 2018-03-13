package com.ksf.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static javax.script.ScriptEngine.FILENAME;

public class Main {

    public static void main(String[] args) {
        String directory = args[0];
        try {
            List<Path> list = Files.find(Paths.get(directory),999,(p, bfa) -> bfa.isRegularFile()).collect(Collectors.toList());
            //list.forEach(System.out::println);

            BufferedReader br = null;
            FileReader fr = null;

            for (Path temp : list) {
                fr = new FileReader(String.valueOf(temp));
                br = new BufferedReader(fr);
                String sCurrentLine;

                while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println(sCurrentLine);
                }
            }

            //br = new BufferedReader(new FileReader(FILENAME));
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
    }
}
