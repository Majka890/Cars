package net.majj.car_sortowanie.sorter_instrukcje;

import net.majj.cars.Car;

import java.util.Comparator;

public class SortByDate implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        int value = o1.getManufacture_time().compareTo(o2.getManufacture_time());
        if (value == 0){
            System.out.println("Dates are the same");
        }
        return value;
    }
}