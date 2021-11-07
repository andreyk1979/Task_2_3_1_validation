package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarsService;


import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarsService cars;

    @Autowired
    public CarsController(CarsService cars) {
        this.cars = cars;
    }

    @GetMapping()
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> result;
        result = cars.getCars(count);
        model.addAttribute("cars", result);
        return "cars";
    }
}
