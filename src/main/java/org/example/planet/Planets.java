package org.example.planet;

public enum Planets {
    OFFLINE(0, "-"),
    ON_GROUND(0, "The rocket has took off!"),
    TROPOSPHERE(25, "Troposphere has been reached"),
    OZONE_LAYER(50, "The ozone layer has been reached"),
    STRATOSPHERE(75, "We are currently in the stratosphere"),
    EXOSPHERE(150, "The Exosphere has been reached"),
    SPACE(200, "Successfully reached space"),
    MOON(300, "Arrived at the moon!");

    public final int requiredRange;
    public final String arrivalMessage;

    Planets(int range, String arrivalMessage) {
        requiredRange = range;
        this.arrivalMessage = arrivalMessage;
    }
}
