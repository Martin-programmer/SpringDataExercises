package course.springdata.restMVC.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(name = "name",required = false,defaultValue = "Stranger") String name){
        return String.format("Hello %s, from Spring MVC!%n",name);
    }
}
