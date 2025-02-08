package org.example.helper;

import java.util.List;

public class PrintHelper {

    public static void printTitle(String title) {
        System.out.printf("\n" + StringFormatter.TITLE_FORMAT, title);
    }

    public static void printOption(String option) {
        System.out.printf(StringFormatter.OPTION_FORMAT, option);
    }

    public static void printAllOptions(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            String formattedOption = String.format("%1$s) %2$s\n", (i + 1), options.get(i));
            PrintHelper.printOption(formattedOption);
        }
    }
}
