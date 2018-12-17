package com.freetour.danang.controllers;

import com.freetour.danang.dto.CategoryDTO;
import com.freetour.danang.dto.Reponse.Response;
import com.freetour.danang.services.ThingToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ThingToDoController {
    @Autowired
    private ThingToDoService thingToDoService;

    @GetMapping(value = "/")
    public ModelAndView getIndex(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listThingtodo",thingToDoService.getListThingToDo());
        mav.setViewName("index");
        return mav;
    }
    @GetMapping(value = "/web-catalog-{id}")
    public ModelAndView getCatalogEat(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listThingtodo",thingToDoService.getListThingToDo());
        mav.addObject("listRes",thingToDoService.listStore(id));
        mav.addObject("getMenu", thingToDoService.getMenuRes(id));
        mav.setViewName("store");
        return mav;
    }
    //======================================PARTNER========================================//
    @GetMapping(value = "/partnerInfo-{id}")
    public ModelAndView getPartnerInfo(@PathVariable(value = "id") Long id, Model model){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listThingtodo",thingToDoService.getListThingToDo());
        mav.addObject("getPartNer", thingToDoService.getPartNer(id));
        mav.addObject("getListMenu", thingToDoService.getPartNerMenu(id));
        mav.addObject("getFeatured", thingToDoService.getFeatured(id));
        mav.setViewName("partnerInfo");
        return mav;
    }
    //========================================MENU===========================================//
    @GetMapping(value = "/catalog-{id}")
    public ModelAndView getResMenuEat(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listThingtodo",thingToDoService.getListThingToDo());
        mav.addObject("getPartNer", thingToDoService.getPartNer(id));
        mav.addObject("getListMenuFood", thingToDoService.getMenuFood(id));
        mav.addObject("getListMenuDrink", thingToDoService.getMenuDrink(id));
        mav.setViewName("menu");
        return mav;
    }
}
