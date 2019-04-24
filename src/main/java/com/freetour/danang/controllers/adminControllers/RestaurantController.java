package com.freetour.danang.controllers.adminControllers;

import com.freetour.danang.dao.models.Restaurant;
import com.freetour.danang.dto.RestaurantDTO;
import com.freetour.danang.services.AdminService;
import com.freetour.danang.services.ThingToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class RestaurantController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ThingToDoService thingToDoService;


    /*----------------------------------List Restaurant or List Relax---------------------------------------------*/

    @GetMapping(value ="/admin/thing-To-Do-{id}")
    public ModelAndView getListRestaurant(@PathVariable(value = "id") Long id,HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("listStore",adminService.listStore(id));
        mav.addObject("getListRelax", thingToDoService.getListRelax(id));
        mav.addObject("id",id);
        mav.setViewName("admin/store");
        return mav;
    }
    /*----------------------------------Add Restaurant---------------------------------------------*/
    @GetMapping(value = "/admin/addRestaurant")
    public ModelAndView addRestaurant(HttpSession session){
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
    @PostMapping(value = "/admin/addRestaurant-Process")
    public ModelAndView addRestaurantProcess(RestaurantDTO restaurantDTO){
        ModelAndView mav = new ModelAndView();
        adminService.addRestaurant(restaurantDTO);
        mav.setViewName("redirect:/admin/addRestaurant");
        return mav;
    }

    /*----------------------------------Edit Restaurant---------------------------------------------*/

    @GetMapping(value = "/admin/updateRestaurant-{id}")
    public ModelAndView updateRestaurant(HttpSession session,@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }

        Restaurant restaurant = adminService.findRestaurant(id);
        if(restaurant != null){
            mav.addObject("edit",restaurant);
            mav.addObject("listCategory",adminService.listThingToDo());
        }

        mav.setViewName("admin/editRestaurant");
        return mav;
    }

    @PostMapping(value = "/admin/restaurant-process")
    public ModelAndView updateRestaurantProcess( RestaurantDTO restaurantDTO){
        ModelAndView mav = new ModelAndView();
        adminService.updateRstaurant(restaurantDTO);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    /*----------------------------------Detail Restaurant---------------------------------------------*/

    @GetMapping(value = "/admin/store-detail-{id}")
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


    /*----------------------------------Delete Store(Restaurant)---------------------------------------------*/
    @GetMapping(value = "/admin/store-{id}-delete")
    public ModelAndView deleteStore(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        adminService.deleteStore(id);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }

}
