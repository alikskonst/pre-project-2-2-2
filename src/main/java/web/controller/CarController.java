package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String cars1(ModelMap model) {
        model.addAttribute("carList", carList);
        return "cars";
    }

//    @GetMapping(value = "/cars")
//    public String cars2(ModelMap model, @RequestParam int count) {
//        model.addAttribute("carList", count >= carList.size() ? carList : carList.subList(0, count));
//        return "cars";
//    }
}
