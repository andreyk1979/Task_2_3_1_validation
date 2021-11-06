package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {
    private List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car("mersedes", "red", 2.3));
        cars.add(new Car("BMW", "white", 3.0));
        cars.add(new Car("LADA", "red", 1.8));
        cars.add(new Car("KIA", "red", 1.6));
        cars.add(new Car("Shkoda", "red", 1.4));
    }

    public List<Car> index() {
        return cars;
    }
//
//    public List<Car> getCars(int id) {
//        return cars.stream().filter(car -> car.)
//
//        }
//        return cars;
//    }

}
