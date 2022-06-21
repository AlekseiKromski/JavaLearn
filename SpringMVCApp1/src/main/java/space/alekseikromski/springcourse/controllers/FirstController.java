package space.alekseikromski.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, Model model){

        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(Model model){
        return "first/goodbye";
    }

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam(value = "a", required = false) Integer a,
            @RequestParam(value = "b", required = false) Integer b,
            @RequestParam(value = "action", required = false) String action,
            Model model
    ){
        Number result = null;
        switch (action){
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / b;
                break;
        }

        model.addAttribute("result", result);

        return "first/calculate";
    }
}
