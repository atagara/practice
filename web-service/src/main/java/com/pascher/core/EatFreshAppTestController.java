package com.pascher.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/eat-fresh")
public class EatFreshAppTestController {
    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    String sayHello(@RequestParam(value="name", required=false, defaultValue="there") String name) {
        String response = new String("Hello " + name + " !!!. Welcome to eat fresh.");
        response = response + "\n We are committed to reducing your cost to an infinitesimal value.";
        response = response + "\n Enjoy your shopping experience at eat Fresh.";
        return response;
    }
}
