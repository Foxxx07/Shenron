package com.ksf.main;

import com.ksf.data.Mail;
import com.ksf.data.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String directory = "./maildir/";
        BufferedReader br = null;
        FileReader fr = null;
        String regexFrom = "([A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$)";
        String regexTo = "(\\ATo:)(.+@.+.com)";
        Set<User> userList = new HashSet<User>();
        Set<Mail> mailList = new HashSet<Mail>();
        User newUser = null;
        boolean userExist;
        try {
            List<Path> list = Files.find(Paths.get(directory), 999, (p, bfa) -> bfa.isRegularFile()).collect(Collectors.toList());
            for (Path path : list) {
                try {
                    fr = new FileReader(String.valueOf(path));
                    br = new BufferedReader(fr);
                    //br = new BufferedReader(new FileReader(FILENAME));
                    String sCurrentLine;
                    userExist = false;
                    String mailContent = "";
                    while ((sCurrentLine = br.readLine()) != null) {
                        mailContent += sCurrentLine + "\n";
                        if(sCurrentLine.contains("From")) {
                            final Pattern patternFrom = Pattern.compile(regexFrom, Pattern.CASE_INSENSITIVE);
                            final Matcher matcherFrom = patternFrom.matcher(sCurrentLine);
                            //System.out.println(sCurrentLine);
                            while(matcherFrom.find())
                            {
                                newUser = new User(matcherFrom.group(1));
                                for(User user : userList){
                                    if(newUser.getUserMail().toLowerCase().equals(user.getUserMail().toLowerCase()))
                                    {
                                        userExist = true;
                                        System.out.println(newUser.getUserMail());
                                    }
                                    /*else
                                    {
                                        System.out.println(user.getUserMail());
                                        System.out.println(newUser.getUserMail() + "\n");
                                        userExist = false;
                                    }*/

                                }
                            }
                            //System.out.println(userExist);
                            if(userExist == false)
                                userList.add(newUser);
                            else{
                                //userExist = false;
                            }

                        }
                        //userExist = false;
                        //
                      /*  final Pattern patternTo = Pattern.compile(regexTo);
                        final Matcher matcherTo = patternTo.matcher(sCurrentLine);
                        while (matcherTo.find()) {
                            //System.out.println("Full match: " + matcherTo.group(0));
                            for (int i = 1; i <= matcherTo.groupCount(); i++) {
                                // System.out.println("Group " + i + ": " + matcherTo.group(i));
                            }
                        }*/
                    }
                    mailList.add(new Mail(mailContent));
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

            //list.forEach(System.out::println);
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
        for(Mail mail : mailList){
            System.out.println(mail.getMail());
        }
        for(User user1 : userList){
           System.out.println(user1.getUserMail());
        }
    }
}
