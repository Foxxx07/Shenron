package com.ksf.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static javax.script.ScriptEngine.FILENAME;

public class Main {
    public static void main(String[] args) {
        String directory = args[0];
        try {
            List<Path> list = Files.find(Paths.get(directory),999,(p, bfa) -> bfa.isRegularFile()).collect(Collectors.toList());
            //list.forEach(System.out::println);

            List<String> mail = new ArrayList<>();

            BufferedReader br = null;
            FileReader fr = null;

            for (Path temp : list) {
                fr = new FileReader(String.valueOf(temp));
                br = new BufferedReader(fr);
                String sCurrentLine;

                while ((sCurrentLine = br.readLine()) != null) {
                    Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(sCurrentLine);
                    while (m.find()) {
                        if(sCurrentLine.contains("To")){
                            if(!Arrays.asList(mail).contains(m.group())){
                                System.out.println(m.group());
                                mail.add(m.group());
                            }
                        }
                    }
/*
                    System.out.println(sCurrentLine);
*/
                }

//                System.out.println(mail.toString());
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
    }
}
