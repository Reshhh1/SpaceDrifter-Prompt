package org.example.dialog;

import org.example.helper.PrintHelper;
import org.example.rocket.Planets;
import org.example.rocket.Rocket;
import org.example.rocket.SpaceTravelSimulator;
import org.example.storage.RocketStorage;

import java.sql.SQLOutput;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DisplayRocketDialog implements Dialog {
    private final RocketStorage rocketStorage;
    private final Scanner input;
    private final SpaceTravelSimulator spaceTravelSimulator;

    public DisplayRocketDialog(Scanner input, RocketStorage rocketStorage, SpaceTravelSimulator spaceTravelSimulator) {
        this.rocketStorage = rocketStorage;
        this.input = input;
        this.spaceTravelSimulator = spaceTravelSimulator;
    }

    @Override
    public void start() {
        loadRocket();
    }

    private void loadRocket() {
        ArrayList<Rocket> allRockets = rocketStorage.getAllRockets();
        System.out.print("Configure rocket:");
        int rocketId = Integer.parseInt(input.nextLine());
        System.out.println(rocketId);

        if (rocketId != 0) {
            displayRocketDetails(allRockets.get(rocketId - 1));
        }
    }

    private void displayRocketDetails(Rocket rocket) {
        PrintHelper.printTitle(rocket.getName() + " | Configuration");
        String formattedCreateAtDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(rocket.getCreatedAt());
        System.out.printf("Name: %s\tFuel: %d Created_at: %s%n", rocket.getName(), rocket.getFuel(),formattedCreateAtDate);
        PrintHelper.printAllOptions(Arrays.asList("Launch", "Remove"));
        System.out.print("Choose an option:");
        handleRocketOptions(rocket);
    }

    private void handleRocketOptions(Rocket rocket) {
        int option = Integer.parseInt(input.nextLine());

        switch (option) {
            case 1:
                if (rocket.getCurrentDestination() != Planets.OFFLINE) {
                    rocket.launch();
                    spaceTravelSimulator.simulateTravel(rocket);
                } else {
                    System.out.println("This rocket is currently offline due to a crash");
                }
                break;
            case 2:
                rocketStorage.removeRocket(rocket);
                System.out.println("Rocket has been removed!");
                break;
        }
    }
}
