package learning.scaffolding.web.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

    private

    @GetMapping("/hello")
    public String getHelloWorld(@RequestParam(name = "id") int id){
        return "Hello World";
    }
}
