package com.september.controller;

import com.september.model.HistoryShare;
import com.september.service.HistoryShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HistoryShareController {
    @Autowired
    private HistoryShareService historyShareService;

    @GetMapping(value = "/histories")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("historyView");
        List<HistoryShare> list = historyShareService.queryElements();

        modelAndView.addObject("historyList", list);
        return modelAndView;
    }
}
