package com.student.util;

import java.io.Console;

public class PasswordMasker {

    public static String readPassword(String prompt) {
        Console console = System.console();

        if (console != null) {
            char[] passwordArray = console.readPassword(prompt);
            return new String(passwordArray);
        } else {
            // fallback (IDE lo console support undakapothe)
            System.out.print(prompt);
            return new java.util.Scanner(System.in).nextLine();
        }
    }
}