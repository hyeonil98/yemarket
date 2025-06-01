package com.yemarket.booking.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("member/login");
        return mav;
    }

    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("member/register");
        return mav;
    }
}
