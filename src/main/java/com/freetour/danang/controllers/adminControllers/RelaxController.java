package com.freetour.danang.controllers.adminControllers;

import com.freetour.danang.dao.models.MenuRelax;
import com.freetour.danang.dao.models.Relax;
import com.freetour.danang.dto.MenuRelaxDTO;
import com.freetour.danang.dto.RelaxDTO;
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
public class RelaxController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ThingToDoService thingToDoService;
    /***********----------------------------Relax-------------------------***********/
    /*-----------------------------Add Relax------------------------- */

    @GetMapping(value = "/admin/addRelax")
    public ModelAndView addRelax(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("addRelax",new RelaxDTO());
        mav.setViewName("admin/addRelax");
        return mav;
    }
    @PostMapping(value = "/admin/addRelax-Process")
    public ModelAndView addRelaxProcess(RelaxDTO relaxDTO){
        ModelAndView mav = new ModelAndView();
        adminService.addRelax(relaxDTO);
        mav.setViewName("redirect:/admin/addRelax");
        return mav;
    }
    /*-----------------------------Update Relax------------------------- */
    @GetMapping(value = "/admin/updateRelax-{id}")
    public ModelAndView updateRelax(HttpSession session, @PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }

        Relax relax = adminService.findRelax(id);
        if(relax != null){
            mav.addObject("editRelax",relax);

        }

        mav.setViewName("admin/editRelax");
        return mav;
    }

    @PostMapping(value = "/admin/updateRelax-process")
    public ModelAndView updateRelaxProcess( RelaxDTO relaxDTO){
        ModelAndView mav = new ModelAndView();
        adminService.updateRelax(relaxDTO);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    /*-----------------------------Detail Relax------------------------- */
    @GetMapping(value = "/admin/detailRelax-{id}")
    public ModelAndView detailRelax(@PathVariable(value = "id") Long id, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("detailRelax",adminService.detailRelax(id));
        mav.setViewName("admin/detailRelax");
        return mav;
    }

    /*-----------------------------Delete Relax------------------------- */
    @GetMapping(value = "/admin/deleteRelax-{id}")
    public ModelAndView deleteRelax(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        adminService.deleteRelax(id);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    /***********----------------------------Relax-------------------------***********/



    /***********----------------------------Menu Relax-------------------------***********/
    /*-----------------------------List Menu Relax------------------------- */
    @GetMapping(value = "/admin/relax-{id}")
    public ModelAndView getListMenuRelax(@PathVariable(value = "id") Long id,HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("getListMenuRelax", thingToDoService.getMenuRelax(id));
        mav.setViewName("admin/menu-relax");
        return mav;
    }
    /*-----------------------------Add Menu Relax Process------------------------- */
    @GetMapping(value = "/admin/addMenuRelax")
    public ModelAndView addMenuRelax(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("addMenuRelax",new MenuRelaxDTO());
        mav.addObject("ListRelax",adminService.ListRelax());
        mav.setViewName("admin/addMenuRelax");
        return mav;
    }
    @PostMapping(value = "/admin/addMenuRelax-Process")
    public ModelAndView addMenuRelaxProcess(MenuRelaxDTO menuRelaxDTO){
        ModelAndView mav = new ModelAndView();
        adminService.addMenuRelax(menuRelaxDTO);
        mav.setViewName("redirect:/admin/addMenuRelax");
        return mav;
    }
    /*-----------------------------Update  Menu Relax------------------------- */
    @GetMapping(value = "/admin/updateMenuRelax-{id}")
    public ModelAndView updateMenuRelax(HttpSession session,@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }

        MenuRelax menuRelax = adminService.findMenuRelax(id);
        if(menuRelax != null){
            mav.addObject("editMenuRelax",menuRelax);
            mav.addObject("ListRelax",adminService.ListRelax());
        }

        mav.setViewName("admin/editMenuRelax");
        return mav;
    }

    @PostMapping(value = "/admin/updateMenuRelax-process")
    public ModelAndView updateMenuRelaxProcess( MenuRelaxDTO menuRelaxDTO){
        ModelAndView mav = new ModelAndView();
        adminService.updateMenuRelax(menuRelaxDTO);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    /*-----------------------------Detail  Menu Relax------------------------- */
    @GetMapping(value = "/admin/detailMenuRelax-{id}")
    public ModelAndView detailMenuRelax(@PathVariable(value = "id") Long id, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("detailMenuRelax",adminService.detailMenuRelax(id));
        mav.setViewName("admin/detailMenuRelax");
        return mav;
    }

    /*-----------------------------Delete Menu Relax------------------------- */
    @GetMapping(value = "/admin/deleteMenuRelax-{id}")
    public ModelAndView deleteMenuRelax(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        adminService.deleteMenuRelax(id);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
}
