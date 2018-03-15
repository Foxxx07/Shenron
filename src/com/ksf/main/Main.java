package com.ksf.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String directory = "./maildir/";
        BufferedReader br = null;
        FileReader fr = null;
        try {
            List<Path> list = Files.find(Paths.get(directory),999,(p, bfa) -> bfa.isRegularFile()).collect(Collectors.toList());
            for(Path path : list){
                try {
                fr = new FileReader(String.valueOf(path));
                br = new BufferedReader(fr);
                    //br = new BufferedReader(new FileReader(FILENAME));
                    fr = new FileReader(String.valueOf(path));
                    br = new BufferedReader(fr);

                    String sCurrentLine;

                    while ((sCurrentLine = br.readLine()) != null) {
                        System.out.println(sCurrentLine);
                    }

                } catch (IOException e) {

                    e.printStackTrace();

                } finally {

                    try {

                        if (br != null)
                            br.close();

                        if (fr != null)
                            fr.close();

                    } catch (IOException ex) {

                        ex.printStackTrace();

                    }

                }
            }

            list.forEach(System.out::println);
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
    }
}
