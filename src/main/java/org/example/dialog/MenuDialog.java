package org.example.dialog;

import org.example.helper.PrintHelper;

import java.util.Arrays;
import java.util.Scanner;

public class MenuDialog implements Dialog {

    private final RocketCreationDialog rocketCreationDialog;
    private final DisplayAllRocketDialog displayAllRocketDialog;
    private final Scanner input;

    public MenuDialog(
            RocketCreationDialog rocketCreationDialog,
            DisplayAllRocketDialog displayAllRocketDialog,
            Scanner input
    ) {
        this.rocketCreationDialog = rocketCreationDialog;
        this.displayAllRocketDialog = displayAllRocketDialog;
        this.input = input;
    }

    @Override
    public void start() {
        displayMainMenu();
    }

    private void displayMainMenu() {
        PrintHelper.printTitle("Main Menu");
        PrintHelper.printAllOptions(Arrays.asList("Create rockets", "Display all rockets"));
        System.out.print("Choose an option:");
        handleMenuOptions();
    }

    private void handleMenuOptions() {
        int optionNumber = Integer.parseInt(input.nextLine());

        switch (optionNumber) {
            case 1:
                rocketCreationDialog.start();
                break;
            case 2:
                displayAllRocketDialog.start();
                break;
        }
    }
}
