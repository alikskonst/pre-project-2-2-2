package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class CarController {

    public static final List<Car> carList = Collections.unmodifiableList(
            new ArrayList<Car>() {{
                add(new Car(1L, "Brand1", "Model1"));
                add(new Car(2L, "Brand2", "Model2"));
                add(new Car(3L, "Brand3", "Model3"));
                add(new Car(4L, "Brand4", "Model4"));
                add(new Car(5L, "Brand5", "Model5"));
            }}
    );

    @GetMapping(value = "/cars")
    public String getAllCars(ModelMap model) {
        model.addAttribute("carList", carList);
        return "cars";
    }

    @GetMapping(value = "/cars?count={count}")
    public String getCountOfCars(ModelMap model, @PathVariable int count) {
        model.addAttribute("carList", count >= carList.size() ? carList : carList.subList(0, count));
        return "cars";
    }
}
