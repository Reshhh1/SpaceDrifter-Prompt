package org.example.rocket;

import org.example.helper.PrintHelper;

import java.time.LocalDateTime;

public class Rocket implements RocketProtocols {
    private String name;
    private int fuel;
    private Planets currentDestination = Planets.ON_GROUND;
    private LocalDateTime createdAt;

    public Rocket(String name, int fuel, LocalDateTime createdAt) {
        this.name = name;
        this.fuel = fuel;
        this.createdAt = createdAt;
    }

    @Override
    public void launch() {
        PrintHelper.printTitle("Launch Program");
        startEngine();
    }

    private void startEngine() {
        System.out.println("[!] THE ENGINE HAS BEEN STARTED");
        System.out.println("Fueled for: " + fuel + "L" + "current destination: " + currentDestination);
        System.out.println(this.name + " is flying!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Planets getCurrentDestination() {
        return currentDestination;
    }

    public void setCurrentDestination(Planets currentDestination) {
        this.currentDestination = currentDestination;
    }
}
