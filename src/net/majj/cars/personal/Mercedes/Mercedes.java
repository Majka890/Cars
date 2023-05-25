package net.majj.cars.personal.Mercedes;

import net.majj.cars.personal.Personal;

public class Mercedes extends Personal {
    protected boolean heated_seats;

    public Mercedes(Object... arguments) {
        super(arguments);
        this.heated_seats = determine_has_heated_seats();
    }

    private boolean determine_has_heated_seats() {
        return Math.random() < 0.5;
    }

    public boolean getHeatedSeats() {
        return heated_seats;
    }
}
