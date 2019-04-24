package com.freetour.danang.controllers.adminControllers;

import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dto.MenuDTO;
import com.freetour.danang.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@RestController
public class MenuContreller {
    @Autowired
    private AdminService adminService;


    /*----------------------------------List Menu---------------------------------------------*/
    @GetMapping(value = "/admin/store-{id}")
    public ModelAndView getListMenu(@PathVariable(value = "id") Long id, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("listMenu",adminService.listMenu(id));
        mav.setViewName("admin/menu");
        return mav;
    }
    /*----------------------------------Add Menu---------------------------------------------*/
    @GetMapping(value = "/admin/addMenu")
    public ModelAndView addMenu(HttpSession session){
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
    @PostMapping(value = "/admin/addMenu-Process")
    public ModelAndView addMenuProcess(MenuDTO menuDTO){
        ModelAndView mav = new ModelAndView();
        adminService.addMenu(menuDTO);
        mav.setViewName("redirect:/admin/addMenu");
        return mav;
    }
    /*----------------------------------Update Menu----------------------------------------*/

    @GetMapping(value = "/admin/updateMenu-{id}")
    public ModelAndView updateMenu(HttpSession session,@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }

        Menu menu = adminService.findMenu(id);
        if(menu != null){
            mav.addObject("edit",menu);
            mav.addObject("listRestaurant",adminService.listRes());
        }

        mav.setViewName("admin/editMenu");
        return mav;
    }

    @PostMapping(value = "/admin/menu-process")
    public ModelAndView updateMenuProcess( MenuDTO menuDTO){
        ModelAndView mav = new ModelAndView();
        adminService.updateMenu(menuDTO);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    /*----------------------------------Detail Menu---------------------------------------------*/

    @GetMapping(value = "admin/menu-detail-{id}")
    public ModelAndView detailMenu(@PathVariable(value = "id") Long id, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("detail",adminService.detailMenu(id));
        mav.setViewName("admin/detailMenu");
        return mav;
    }



    /*----------------------------------Delete Menu---------------------------------------------*/
    @GetMapping(value = "/admin/menu-{id}-delete")
    public ModelAndView deleteMenu(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        adminService.deleteMenu(id);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
}
