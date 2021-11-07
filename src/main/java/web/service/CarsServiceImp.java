package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.CarsDaoImp;
import web.models.Car;

import java.util.List;

@Component
public class CarsServiceImp implements CarsService {

    CarsDaoImp carsDaoImp;

    @Autowired
    public CarsServiceImp(CarsDaoImp carsDaoImp) {
        this.carsDaoImp = carsDaoImp;
    }

    @Override
    public List<Car> getCars(int number) {
        return carsDaoImp.getCars(number);
    }
}
