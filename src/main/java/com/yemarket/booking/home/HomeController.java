package com.yemarket.booking.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping(value = "")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
