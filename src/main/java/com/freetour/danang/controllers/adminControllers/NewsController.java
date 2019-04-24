package com.freetour.danang.controllers.adminControllers;

import com.freetour.danang.dao.models.New;
import com.freetour.danang.dto.NewDTO;
import com.freetour.danang.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@RestController
public class NewsController {
    @Autowired
    private AdminService adminService;

    /*-----------------------------Add News------------------------- */
    @GetMapping(value = "/admin/list-new")
    public ModelAndView getListNews(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("listNew",adminService.listNew());
        mav.setViewName("admin/listNew");
        return mav;
    }

    @GetMapping(value = "/admin/addNew")
    public ModelAndView addNew(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("addNew",new NewDTO());
        mav.setViewName("admin/addNew");
        return mav;
    }
    @PostMapping(value = "/admin/addNew-Process")
    public ModelAndView addNewProcess(NewDTO newDTO){
        ModelAndView mav = new ModelAndView();
        adminService.addNew(newDTO);
        mav.setViewName("redirect:/admin/list-new");
        return mav;
    }

    /*-----------------------------UpDate News------------------------- */

    @GetMapping(value = "/admin/updateNews-{id}")
    public ModelAndView updateNews(HttpSession session,@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }

        New aNew = adminService.findNew(id);
        if(aNew != null){
            mav.addObject("editNew",aNew);
        }

        mav.setViewName("admin/editNew");
        return mav;
    }

    @PostMapping(value = "/admin/updateNews-process")
    public ModelAndView updateNewsProcess( NewDTO newDTO){
        ModelAndView mav = new ModelAndView();
        adminService.updateNews(newDTO);
        mav.setViewName("redirect:/admin/list-new");
        return mav;
    }
    /* -----------------------------Detail News -------------------------------------- */
    @GetMapping(value = "/admin/detailNews-{id}")
    public ModelAndView detailNews(@PathVariable(value = "id") Long id, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("detailNews",adminService.detailNews(id));
        mav.setViewName("admin/detailNews");
        return mav;
    }
    /*-----------------------------Delete News------------------------- */
    @GetMapping(value = "/admin/deleteNews/{id}")
    public ModelAndView deleteNews(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        adminService.deleteNews(id);
        mav.setViewName("redirect:/admin/list-new");
        return mav;
    }
}
