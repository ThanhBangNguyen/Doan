package com.freetour.danang.controllers.adminControllers;

import com.freetour.danang.dao.models.Category;
import com.freetour.danang.dto.CategoryDTO;
import com.freetour.danang.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@RestController
public class CategoryController {
    @Autowired
    private AdminService adminService;


    /*----------------------------------List Category---------------------------------------------*/
    @GetMapping(value = "/admin/things-To-Do")
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
    /*----------------------------------Add Category---------------------------------------------*/
    @GetMapping(value = "/admin/addThingsToDo")
    public ModelAndView addCategory(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("add",new CategoryDTO());
        mav.setViewName("admin/addThingToDo");
        return mav;
    }
    @PostMapping(value = "/admin/addThingsToDo-Process")
    public ModelAndView addCategoryProcess(CategoryDTO categoryDTO){
        ModelAndView mav = new ModelAndView();
        adminService.addThingToDo(categoryDTO);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    /*----------------------------------Update Category---------------------------------------------*/

    @GetMapping(value = "/admin/updateCategory-{id}")
    public ModelAndView updateCategory(HttpSession session,@PathVariable(value = "id") Long id
            ){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }

        //Giờ muốn kiểm tra có lấy đc hay k mình thêm check: về nguyên tắc thì phải lấy được dữ liệu mới  model qua
        Category category = adminService.findCategory(id);
        if(category != null){
            mav.addObject("edit",category);
        }

        mav.setViewName("admin/editCategory");
        return mav;
    }

    @PostMapping(value = "/admin/category-process")
    //Cach Debug : Chặn ở dòng đầu-> run->debug server-> nhấnn nút F8 , muốn kết thúc debug thì F10
    public ModelAndView updateCategoryProcess( CategoryDTO categoryDTO){
        ModelAndView mav = new ModelAndView();
        adminService.updateCategory(categoryDTO);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    /*----------------------------------Delete Category---------------------------------------------*/
    @GetMapping(value = "/admin/thingToDo-{id}-delete")
    public ModelAndView deleteThingToDo(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        adminService.deleteThingToDo(id);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
}
