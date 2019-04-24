package com.freetour.danang.controllers;

import com.freetour.danang.services.NewService;
import com.freetour.danang.services.ThingToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ThingToDoController {
    @Autowired
    private ThingToDoService thingToDoService;
    @Autowired
    private NewService newService;

    @GetMapping(value = "/")
    public ModelAndView getIndex(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listThingtodo",thingToDoService.getListThingToDo());
        mav.addObject("firstNew",newService.findNew());
        mav.addObject("listNew",newService.listNew());
        mav.setViewName("index");

        return mav;
    }

    /*-------------------------- Tin Tức ------------------------------*/
    @GetMapping(value = "/readNews-{id}")
    public ModelAndView readNews(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("firstNew",newService.findNew());
        mav.addObject("listNew",newService.listNew());
        mav.addObject("readNews",newService.readNews(id));
        mav.setViewName("post");
        return mav;
    }

    @GetMapping(value = "/web-catalog-{id}")
    public ModelAndView getCatalog(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listThingtodo",thingToDoService.getListThingToDo());
        mav.addObject("listRes",thingToDoService.listStore(id));
        mav.addObject("id",id);
        mav.addObject("getMenu", thingToDoService.getMenuRes(id));
        if (id ==4  ){
            mav.addObject("getListRelax", thingToDoService.getListRelax(id));
            }
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
    public ModelAndView displayMenuEat(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listThingtodo",thingToDoService.getListThingToDo());
        mav.addObject("getPartNer", thingToDoService.getPartNer(id));
        mav.addObject("getListMenuFood", thingToDoService.getMenuFood(id));
        mav.addObject("getListMenuDrink", thingToDoService.getMenuDrink(id));
        mav.setViewName("menu");
        return mav;
    }
    @GetMapping(value = "/catalogrelax-{id}")
    public ModelAndView displayMenuRelax(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listThingtodo",thingToDoService.getListThingToDo());
        mav.addObject("getInforRelax", thingToDoService.getInforRelax(id));
        mav.addObject("getListMenuRelax", thingToDoService.getMenuRelax(id));
        mav.setViewName("menurelax");
        return mav;
    }
}
