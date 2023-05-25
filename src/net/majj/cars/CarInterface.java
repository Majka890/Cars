package net.majj.cars;

import net.majj.exceptions.ArgumentListTooShortException;

public interface CarInterface {

    public String getCarName();

    public Car getNewInstance(Object... arguments) throws ArgumentListTooShortException;
}
