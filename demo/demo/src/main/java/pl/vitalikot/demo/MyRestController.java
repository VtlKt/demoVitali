package pl.vitalikot.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    @GetMapping("/first/endpoint")
    public String myGet() {
        return "Hello World";
    }

    @GetMapping("/tickets/{id}")
    public String myGetter(@PathVariable long id, @RequestParam String name) {
        return id + " " + name;
    }

    @GetMapping("/name")
    public String myName(@RequestHeader String name) {
        return "My name: " + name;
    }
}
