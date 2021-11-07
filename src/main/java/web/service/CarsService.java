package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.List;

public interface CarsService {
    List<Car> getCars(int number);
}
