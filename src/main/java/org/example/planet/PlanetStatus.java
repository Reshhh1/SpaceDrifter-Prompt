package org.example.planet;

public class PlanetStatus {
    private final Planets planet;
    private boolean hasReached;

    public PlanetStatus(Planets planet, boolean hasReached) {
        this.planet = planet;
        this.hasReached = hasReached;
    }

    public Planets getPlanet() {
        return planet;
    }

    public boolean HasReached() {
        return hasReached;
    }

    public void setHasReached(boolean hasReached) {
        this.hasReached = hasReached;
    }
}