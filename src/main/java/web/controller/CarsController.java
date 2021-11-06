package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private final CarService cars;

    public CarsController(CarService cars) {
        this.cars = cars;
    }

    @GetMapping()
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
//        cars.setCar("mersedes", "red", 2.3);
//        cars.setCar("BMW", "white", 3.0);
//        cars.setCar("LADA", "red", 1.8);
//        cars.setCar("KIA", "red", 1.6);
//        cars.setCar("Shkoda", "red", 1.4);
        List<Car> result;
        result = cars.getCars(count);
        model.addAttribute("cars", result);
        return "cars";
    }
}
