package com.freetour.danang.controllers;

import com.freetour.danang.dao.models.Category;
import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dao.models.Restaurant;
import com.freetour.danang.dao.models.User;
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
public class AdminController {
    @Autowired
    private AdminService adminService;

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
            session.setAttribute("user", userDTO);
            session.removeAttribute("error");
            mav.setViewName("redirect:/admin/");
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
    @GetMapping(value = "/admin")
    public ModelAndView getIndex(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.setViewName("admin/index");
        return mav;
    }
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
        mav.addObject("listUser",adminService.deleteUser(id));
        mav.setViewName("redirect:/bossAdmin");
        return mav;
    }

    @GetMapping(value ="/admin/thing-To-Do-{id}")
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
    @GetMapping(value = "/admin/store-{id}")
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
    @GetMapping(value = "/admin/addThingsToDo")
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
    @PostMapping(value = "/admin/addThingsToDo-Process")
    public ModelAndView getAddThingsToDoProcess(CategoryDTO categoryDTO){
        ModelAndView mav = new ModelAndView();
        mav.addObject("add",adminService.addThingToDo(categoryDTO));
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    @GetMapping(value = "/admin/addRestaurant")
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
    @PostMapping(value = "/admin/addRestaurant-Process")
    public ModelAndView getAddRestaurantProcess(RestaurantDTO restaurantDTO){
        ModelAndView mav = new ModelAndView();
        mav.addObject("add",adminService.addRestaurant(restaurantDTO));
        mav.setViewName("redirect:/admin/addRestaurant");
        return mav;
    }
    @GetMapping(value = "/admin/addMenu")
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
    @PostMapping(value = "/admin/addMenu-Process")
    public ModelAndView getAddMenuProcess(MenuDTO menuDTO){
        ModelAndView mav = new ModelAndView();
        mav.addObject("add",adminService.addMenu(menuDTO));
        mav.setViewName("redirect:/admin/addMenu");
        return mav;
    }
    @GetMapping(value = "/admin/thingToDo-{id}-delete")
    public ModelAndView deleteThingToDo(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listCategory",adminService.deleteThingToDo(id));
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    @GetMapping(value = "/admin/store-{id}-delete")
    public ModelAndView deleteStore(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listStore",adminService.deleteStore(id));
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    @GetMapping(value = "/admin/menu-{id}-delete")
    public ModelAndView deleteMenu(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("listMenu",adminService.deleteMenu(id));
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
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
    ///--------------------------------Detail Menu  --------------------------///
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


    ///-------------------------------Edit Category--------------------------///

    @GetMapping(value = "/admin/updateCategory-{id}")
    public ModelAndView updateCategory(HttpSession session,@PathVariable(value = "id") Long id/*  ở đây chỉ lấy thông tin ra thôi chứ chưa phải cần -> nên nó báo bad Request
    ,sau đó ra đây để gọi nó ra và modelandview qua jsp*/){
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

    @PostMapping(value = "/admin/category-process")//rồi chặn ở dòng đầu-> run->debug server-> nhấnn nút F8 , muốn kết thúc debug thì F10
    public ModelAndView updateCategoryProcess( CategoryDTO categoryDTO){
        ModelAndView mav = new ModelAndView();
        adminService.updateCategory(categoryDTO);
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    ///-------------------------------Edit Restaurant--------------------------///

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
        mav.addObject("edit",adminService.updateRstaurant(restaurantDTO));
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
    ///-------------------------------Edit Menu--------------------------///

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
        mav.addObject("edit",adminService.updateMenu(menuDTO));
        mav.setViewName("redirect:/admin/things-To-Do");
        return mav;
    }
}
