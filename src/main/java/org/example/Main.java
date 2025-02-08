package org.example;

import org.example.dialog.*;
import org.example.rocket.SpaceTravelSimulator;
import org.example.storage.RocketStorage;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("\nThe App is starting...");

        Scanner input = new Scanner(System.in);

//        LaunchPad launchPad = new LaunchPad();
        RocketStorage rocketStorage = new RocketStorage();
        SpaceTravelSimulator spaceTravelSimulator = new SpaceTravelSimulator();

        RocketCreationDialog rocketCreationDialog = new RocketCreationDialog(input, rocketStorage);
        DisplayRocketDialog displayRocketDialog = new DisplayRocketDialog(input, rocketStorage, spaceTravelSimulator);
        DisplayAllRocketDialog displayAllRocketDialog = new DisplayAllRocketDialog(rocketStorage, displayRocketDialog);

        MenuDialog menuDialog = new MenuDialog(rocketCreationDialog, displayAllRocketDialog, input);

        while(true) {
            menuDialog.start();
        }
    }
}