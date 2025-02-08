package org.example.dialog;

import org.example.helper.PrintHelper;
import org.example.rocket.Rocket;
import org.example.storage.RocketStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayAllRocketDialog implements Dialog{
    private final RocketStorage rocketStorage;
    private final DisplayRocketDialog displayRocketDialog;

    public DisplayAllRocketDialog(
            RocketStorage rocketStorage,
            DisplayRocketDialog displayRocketDialog
    ) {
        this.rocketStorage = rocketStorage;
        this.displayRocketDialog = displayRocketDialog;
    }

    @Override
    public void start() {
        loadAllRocketsScenario();
    }

    private void loadAllRocketsScenario() {
        PrintHelper.printTitle("Rocket Storage");
        ArrayList<Rocket> allRockets = rocketStorage.getAllRockets();

        if (allRockets.isEmpty()) {
            System.out.println("Empty rocket storage!");
            return;
        }

        displayListOfRockets(allRockets);
        displayRocketDialog.start();
    }

    private void displayListOfRockets(ArrayList<Rocket> rockets) {
        PrintHelper.printOption("0. Return to menu\n");
        for (int i = 0; i < rockets.size(); i++) {
            PrintHelper.printOption((i + 1) + ". " + rockets.get(i).getName() + "\n");
        }
    }
}
