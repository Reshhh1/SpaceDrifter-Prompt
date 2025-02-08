package org.example.storage;

import org.example.rocket.Rocket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class RocketStorage {
    private final ArrayList<Rocket> rockets = new ArrayList<Rocket>(
            Arrays.asList(
                    new Rocket("STARLINK", 1000, LocalDateTime.now()),
                    new Rocket("NASA-101", 10, LocalDateTime.now()),
                    new Rocket("FLYING-CAT", 1010, LocalDateTime.now()),
                    new Rocket("SPACE-CRASHER", 90, LocalDateTime.now())
            )
    );

    public void addRocket(Rocket newRocket) {
        rockets.add(newRocket);
    }

    public ArrayList<Rocket> getAllRockets() {
        return rockets;
    }

    public void removeRocket(Rocket rocket) {
        this.rockets.remove(rocket);
    }
}
