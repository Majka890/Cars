import net.majj.car_factory.Factory;
import net.majj.car_queue.CarQueue;
import net.majj.car_sortowanie.CarSorter;
import net.majj.car_sortowanie.sorter_instrukcje.SortByDateAndColour;
import net.majj.cars.personal.Skoda.Skoda;
import net.majj.cars.personal.Skoda.SkodaInstruction;
import net.majj.cars.personal.Personal;
import net.majj.cars.personal.Mercedes.Mercedes;
import net.majj.cars.personal.Mercedes.MercedesInstruction;
import net.majj.serializer.Serializer;
import net.majj.cars.Car;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Serializer serializer = new Serializer();
        Factory factory = new Factory();
        List<Car> cars = new ArrayList<>();

        cars = Return10Cars(factory, cars);

        CarSorter sorter = new CarSorter(cars);

        PrintCars(cars);

        PrintCars(sorter.getCarsSortedByDoM());

        PrintCars(sorter.getCarsSortedByColour());
        PrintCars(sorter.getCarsSortedByColourReversed());

        PrintCars(cars);

        ArrayDeque<Car> queue = get_car_queue(cars);
        CarQueue carQueue = new CarQueue(queue);
        carQueue.PrintQueue();

        PriorityQueue<Car> sorted_queue = get_car_presorted_queue(cars);
        CarQueue presorted_car_Queue = new CarQueue(sorted_queue);
        presorted_car_Queue.PrintQueue();

        serializer.serialize("cars.dat", cars);
    }

    public static ArrayDeque<Car> get_car_queue(List<Car> cars) {
        ArrayDeque<Car> queue = new ArrayDeque<>();
        for(Car car: cars) {
            queue.offer(car);
        }
        return queue;
    }

    public static PriorityQueue<Car> get_car_presorted_queue(List<Car> cars) {
        PriorityQueue<Car> queue = new PriorityQueue<>(new SortByDateAndColour());
        for(Car car: cars) {
            queue.offer(car);
        }
        return queue;
    }

    public static List<Car> Return10Cars(Factory factory, List<Car> cars){
        factory.addInstruction(new SkodaInstruction());
        factory.addInstruction(new MercedesInstruction());

        cars.add(factory.getCarByName("Mercedes", 95, 5, "12/05/2002", "red", true));
        cars.add(factory.getCarByName("Skoda", 70, 3, "12/09/2003", "blue", false));
        cars.add(factory.getCarByName("Mercedes", 95, 5, "12/05/2002", "green", true));
        cars.add(factory.getCarByName("Skoda", 70, 3, "12/02/2008", "blue", false));
        cars.add(factory.getCarByName("Mercedes", 95, 5, "12/05/2012", "purple", true));
        cars.add(factory.getCarByName("Skoda", 70, 3, "12/07/2006", "orange", false));
        cars.add(factory.getCarByName("Mercedes", 95, 5, "12/05/2015", "red", true));
        cars.add(factory.getCarByName("Skoda", 70, 3, "12/05/2007", "green", false));
        cars.add(factory.getCarByName("Mercedes", 95, 5, "12/04/2001", "black", true));
        cars.add(factory.getCarByName("Skoda", 70, 3, "12/06/1999", "blue", false));

        return cars;
    }

    public static void PrintCars(List<Car> cars) {
        for (Car car: cars) {
            try {
                System.out.println(car.getHorse_power() + " " + car.getDoor_count());
                System.out.println(car.getColour());
                System.out.println(car.getManufacture_time());
                if(car instanceof Personal) {
                    Personal personal = ((Personal) car);
                    System.out.println(personal.getHasIsoFix());
                    if(personal instanceof Mercedes) {
                        Mercedes vw = ((Mercedes) personal);
                        System.out.println(vw.getHeatedSeats());
                    } else if (personal instanceof Skoda) {
                        Skoda skoda = ((Skoda) personal);
                        System.out.println(skoda.getIsStolen());
                    }
                }
            } catch (NullPointerException error) {
                System.out.println("Instance of " + car + " in not an car");
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}