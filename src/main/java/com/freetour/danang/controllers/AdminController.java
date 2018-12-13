package com.freetour.danang.controllers;

import com.freetour.danang.dto.CategoryDTO;
import com.freetour.danang.dto.MenuDTO;
import com.freetour.danang.dto.RestaurantDTO;
import com.freetour.danang.dto.UserDTO;
import com.freetour.danang.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/login")
    public ModelAndView login(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") != null) {
            mav.setViewName("redirect:/admin/");
        } else {
            mav.addObject("user", new UserDTO());
            mav.setViewName("admin/login");
        }

        return mav;
    }

    @PostMapping(value = "/loginProcess")
    public ModelAndView getLogin(UserDTO userDTO, HttpSession session)  {
        ModelAndView mav= new ModelAndView();
        mav.addObject("user",userDTO = adminService.login(userDTO));
        if (userDTO.getId() != null) {
            session.setAttribute("user", userDTO);
            session.removeAttribute("error");
            mav.setViewName("redirect:/admin/");
        } else {
            mav.addObject("user", new UserDTO());
            mav.setViewName("admin/login");
        }
        return mav;
    }
    @GetMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        session.removeAttribute("user");
        mav.setViewName("redirect:/admin/login");
        return mav;
    }
    @GetMapping(value = "/")
    public ModelAndView getIndex(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.setViewName("admin/index");
        return mav;
    }
    @GetMapping(value = "/things-To-Do")
    public ModelAndView getThingToDo(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("listCategory",adminService.listThingToDo());
        mav.setViewName("admin/category");
        return mav;
    }
    @GetMapping(value = "/thing-To-Do-{id}")
    public ModelAndView getRestaurant(@PathVariable(value = "id") Long id,HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("listStore",adminService.listStore(id));
        mav.setViewName("admin/store");
        return mav;
    }
    @GetMapping(value = "/store-{id}")
    public ModelAndView getMenu(@PathVariable(value = "id") Long id,HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("listMenu",adminService.listMenu(id));
        mav.setViewName("admin/menu");
        return mav;
    }
    @GetMapping(value = "/addThingsToDo")
    public ModelAndView getAddThingsToDo(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("add",new CategoryDTO());
        mav.setViewName("admin/addThingToDo");
        return mav;
    }
    @PostMapping(value = "/addThingsToDo-Process")
    public ModelAndView getAddThingsToDoProcess(CategoryDTO categoryDTO){
        ModelAndView mav = new ModelAndView();
        mav.addObject("add",adminService.addThingToDo(categoryDTO));
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    @GetMapping(value = "/addRestaurant")
    public ModelAndView getAddRestaurant(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("add",new RestaurantDTO());
        mav.addObject("listCategory",adminService.listThingToDo());
        mav.setViewName("admin/addRestaurant");
        return mav;
    }
    @PostMapping(value = "/addRestaurant-Process")
    public ModelAndView getAddRestaurantProcess(RestaurantDTO restaurantDTO){
        ModelAndView mav = new ModelAndView();
        mav.addObject("add",adminService.addRestaurant(restaurantDTO));
        mav.setViewName("redirect:/admin/addRestaurant");
        return mav;
    }
    @GetMapping(value = "/addMenu")
    public ModelAndView getAddMenu(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("add",new MenuDTO());
        mav.addObject("listRestaurant",adminService.listRes());
        mav.setViewName("admin/addMenu");
        return mav;
    }
    @PostMapping(value = "/addMenu-Process")
    public ModelAndView getAddMenuProcess(MenuDTO menuDTO){
        ModelAndView mav = new ModelAndView();
        mav.addObject("add",adminService.addMenu(menuDTO));
        mav.setViewName("redirect:/admin/addMenu");
        return mav;
    }
    @GetMapping(value = "/thingToDo-{id}-delete")
    public ModelAndView deleteThingToDo(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listMenu",adminService.deleteThingToDo(id));
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    @GetMapping(value = "/store-{id}-delete")
    public ModelAndView deleteStore(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listMenu",adminService.deleteStore(id));
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    @GetMapping(value = "/menu-{id}-delete")
    public ModelAndView deleteMenu(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listMenu",adminService.deleteMenu(id));
            mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    @GetMapping(value = "/store-detail-{id}")
    public ModelAndView detailStore(@PathVariable(value = "id") Long id, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("detail",adminService.detailStore(id));
        mav.setViewName("admin/detailStore");
        return mav;
    }
}
