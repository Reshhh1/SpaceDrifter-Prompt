package org.example.rocket;

import java.util.Arrays;
import java.util.List;

public class SpaceTravelSimulator {
    private final List<PlanetStatus> reachedDestinations = Arrays.stream(Planets.values())
            .filter(planet -> planet != Planets.OFFLINE)
            .map(planet -> new PlanetStatus(planet, false))
            .toList();

    private final int FUEL_DEPLETION = 100;
    private final int STARTING_RANGE = 0;

    public void simulateTravel(Rocket rocket) {
        int range = STARTING_RANGE;
        while (rocket.getFuel() > 0) {
            rocket.setFuel(rocket.getFuel() - FUEL_DEPLETION);
            range += 25;
            checkForPlanetMilestone(range);
        }
        if (range < Planets.SPACE.requiredRange) {
            System.out.println("\n[!]CRASH[!]");
            rocket.setCurrentDestination(Planets.OFFLINE);
        }
    }

    private void checkForPlanetMilestone(int range) {
        reachedDestinations.forEach(planetStatus -> {
            if (range > planetStatus.getPlanet().requiredRange && !planetStatus.HasReached()) {
                planetStatus.setHasReached(true);
                System.out.println(planetStatus.getPlanet().arrivalMessage);
            }
        });
    }
}
