package net.majj.cars.personal.Skoda;

import net.majj.cars.personal.Personal;

public class Skoda extends Personal {
    protected boolean is_stolen;

    public Skoda(Object... arguments) {
        super(arguments);
        this.is_stolen = determine_is_stolen();
    }

    private boolean determine_is_stolen() {
        return Math.random() < 0.5;
    }

    public boolean getIsStolen() {
        return is_stolen;
    }

    public void setIsStolen(boolean is_stolen) {
        this.is_stolen = is_stolen;
    }
}
