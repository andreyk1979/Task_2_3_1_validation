package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    public List<Car> getCars(int number) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("mersedes", "red", 2.3));
        cars.add(new Car("BMW", "white", 3.0));
        cars.add(new Car("LADA", "red", 1.8));
        cars.add(new Car("KIA", "red", 1.6));
        cars.add(new Car("Shkoda", "red", 1.4));
        if (number == 0 || number > 5) {
            return cars;
        } else {
            return cars.stream().limit(number).collect(Collectors.toList());
        }
    }
}
