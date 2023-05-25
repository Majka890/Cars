package net.majj.cars.personal.Skoda;

import net.majj.cars.Car;
import net.majj.cars.CarInterface;
import net.majj.exceptions.ArgumentListTooShortException;

public class SkodaInstruction implements CarInterface {
    @Override
    public String getCarName() {
        return "Skoda";
    }

    @Override
    public Car getNewInstance(Object... arguments) throws ArgumentListTooShortException {
        int given_length = arguments.length;
        int expected_length = 5;
        if (given_length == expected_length) {
            return new Skoda(arguments);
        }
        throw new ArgumentListTooShortException(expected_length, given_length);
    }
}
