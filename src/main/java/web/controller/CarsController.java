package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private final CarService cars;

    public CarsController(CarService cars) {
        this.cars = cars;
    }

    @GetMapping()
    public String printCars(ModelMap model) {
        model.addAttribute("cars", cars.index());
        return "cars";
    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//
//        return null;
//    }
    
}
