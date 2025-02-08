package org.example.dialog;

import org.example.helper.PrintHelper;
import org.example.rocket.Rocket;
import org.example.storage.RocketStorage;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class RocketCreationDialog implements Dialog {
    private final Scanner input;
    private final RocketStorage rocketStorage;

    public RocketCreationDialog(Scanner input, RocketStorage rocketStorage) {
        this.input = input;
        this.rocketStorage = rocketStorage;
    }

    @Override
    public void start() {
        rocketCreationScenario();
    }

    private void rocketCreationScenario() {
        PrintHelper.printTitle("Rocket Creation");
        PrintHelper.printOption("Name:");
        String name = input.nextLine();

        PrintHelper.printOption("Fuel:");
        int fuel = Integer.parseInt(input.nextLine());

        Rocket createdRocket = new Rocket(name, fuel, LocalDateTime.now());
        rocketStorage.addRocket(createdRocket);
        System.out.println("Rocket has been created!");
    }
}

