package com.freetour.danang.services;

import com.freetour.danang.dao.models.*;
import com.freetour.danang.dto.*;

import java.util.List;

public interface AdminService {
    /*------------------------Category Admin---------------------------*/
        List<CategoryDTO> listThingToDo();

        void addThingToDo(CategoryDTO categoryDTO);

        void deleteThingToDo(Long id);

        Category findCategory(Long id);

        void updateCategory( CategoryDTO categoryDTO);

    /*------------------------Restaurant Admin---------------------------*/
        List<RestaurantDTO> listStore(Long id);

        List<RestaurantDTO> listRes();

        void addRestaurant(RestaurantDTO restaurantDTO);

        void deleteStore(Long id);

        RestaurantDTO detailStore(Long id);

        Restaurant findRestaurant(Long id);

        void updateRstaurant(RestaurantDTO restaurantDTO);

    /*------------------------Menu Admin---------------------------*/
        List<MenuDTO> listMenu(Long id);

        void addMenu(MenuDTO menuDTO);

        void deleteMenu(Long id);

        MenuDTO detailMenu(Long id);

        Menu findMenu(Long id);
        void updateMenu(MenuDTO menuDTO);

    /*------------------------Relax Admin---------------------------*/
        List<RelaxDTO> ListRelax();

        void addRelax(RelaxDTO relaxDTO);

        void deleteRelax(Long id);

        RelaxDTO detailRelax(Long id);

        Relax findRelax(Long id);
        void updateRelax(RelaxDTO relaxDTO);

    /*------------------------Menu Relax Admin---------------------------*/
        void addMenuRelax(MenuRelaxDTO menuRelaxDTO);

        void deleteMenuRelax(Long id);

        MenuRelaxDTO detailMenuRelax(Long id);

        MenuRelax findMenuRelax(Long id);
        void updateMenuRelax(MenuRelaxDTO menuRelaxDTO);

    /*---------------------------------------------------*/
        UserDTO login(UserDTO userDTO);
    /*---------------Boss-------------------*/

        List<UserDTO> listUser();
        UserDTO loginBoss(UserDTO userDTO);
        void deleteUser(Long id);

    /*--------------- New Admin-------------------*/

        List<NewDTO> listNew();

        void addNew(NewDTO newDTO);

        void deleteNews(Long id);

        New findNew(Long id);

        void updateNews(NewDTO newDTO);

        NewDTO detailNews(Long id);

        Long count();



}
