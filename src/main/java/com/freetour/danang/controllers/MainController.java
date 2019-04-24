package com.freetour.danang.controllers;

import com.freetour.danang.dto.*;
import com.freetour.danang.services.AdminService;
import com.freetour.danang.services.NewService;
import com.freetour.danang.services.ThingToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class MainController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private NewService newService;
    @Autowired
    private ThingToDoService thingToDoService;

    @GetMapping(value = "/admin")
    public ModelAndView getIndex(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){

            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("displayNews",newService.findNew());
        mav.addObject("listNew",newService.listNew());
        mav.addObject("countNews",newService.countNew());
        mav.addObject("countCategory",newService.countCategory());
        mav.addObject("countRestaurant",newService.countRestaurant());
        mav.addObject("countMenu",newService.countMenu());
        mav.setViewName("admin/index");
        return mav;
    }

    @GetMapping(value = "/admin/login")
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

    @PostMapping(value = "/admin/loginProcess")
    public ModelAndView getLogin(UserDTO userDTO, HttpSession session)  {
        ModelAndView mav= new ModelAndView();
        mav.addObject("user",userDTO = adminService.login(userDTO));
        if (userDTO.getId() != null) {

            if(userDTO.getRole().getId()!= 1) {
                session.setAttribute("user", userDTO);
                mav.addObject("listMenu",adminService.listMenu(userDTO.getRestaurantUs().getId()));

                session.removeAttribute("error");
                mav.setViewName("admin/menu");

            }
            else {
                session.setAttribute("user", userDTO);
                session.removeAttribute("error");
                mav.setViewName("redirect:/admin/");
            }

        } else {
            mav.addObject("user", new UserDTO());
            mav.setViewName("admin/login");
        }
        return mav;
    }
    @GetMapping(value = "/admin/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        session.removeAttribute("user");
        mav.setViewName("redirect:/admin/login");
        return mav;
    }
    @GetMapping(value = "/sign-in")
    public ModelAndView signIn(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") != null) {
            mav.setViewName("redirect:/bossAdmin");
        } else {
            mav.addObject("admin", new UserDTO());
            mav.setViewName("admin/account");
        }
        return mav;
    }
    @PostMapping(value = "/loginProcess")
    public ModelAndView signIn(UserDTO userDTO, HttpSession session)  {
        ModelAndView mav= new ModelAndView();
        mav.addObject("admin",userDTO = adminService.loginBoss(userDTO));
        if (userDTO.getId() != null) {
            session.setAttribute("user", userDTO);
            session.removeAttribute("error");
            mav.setViewName("redirect:/bossAdmin");
        } else {
            mav.addObject("user", new UserDTO());
            mav.setViewName("admin/account");
        }
        return mav;
    }
    @GetMapping(value ="/bossAdmin")
    public ModelAndView getUser(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/sign-in");
            return mav;
        }
        mav.addObject("listUser",adminService.listUser());
        mav.setViewName("admin/user");
        return mav;
    }

    @GetMapping(value = "/user-{id}-delete")
    public ModelAndView deleteUser(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        adminService.deleteUser(id);
        mav.setViewName("redirect:/bossAdmin");
        return mav;
    }

}
