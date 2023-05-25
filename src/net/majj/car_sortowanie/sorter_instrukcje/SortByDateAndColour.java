package net.majj.car_sortowanie.sorter_instrukcje;

import net.majj.cars.Car;

import java.util.Comparator;

public class SortByDateAndColour implements Comparator<Car> {
    SortByDate sortByDate = new SortByDate();
    SortByColour sortByColour = new SortByColour();
    @Override
    public int compare(Car o1, Car o2) {
        int value = this.sortByDate.compare(o1, o2);
        if (value == 0 ) {
            return this.sortByColour.compare(o1, o2);
        }
        return value;
    }
}