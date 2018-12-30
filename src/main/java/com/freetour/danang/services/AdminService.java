package com.freetour.danang.services;

import com.freetour.danang.dao.models.*;
import com.freetour.danang.dto.*;

import java.util.List;

public interface AdminService {
    List<CategoryDTO> listThingToDo();

    List<RestaurantDTO> listStore(Long id);

    List<MenuDTO> listMenu(Long id);

    CategoryDTO addThingToDo(CategoryDTO categoryDTO);

    RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO);

    MenuDTO addMenu(MenuDTO menuDTO);

    Category deleteThingToDo(Long id);

    Restaurant deleteStore(Long id);

    Menu deleteMenu(Long id);

    UserDTO login(UserDTO userDTO);

    List<RestaurantDTO> listRes();

    RestaurantDTO detailStore(Long id);

    //-------------------Detail  Menu----------------------//
    MenuDTO detailMenu(Long id);


    //-------------------Edit Category---------------------//
    Category findCategory(Long id);
    void updateCategory( CategoryDTO categoryDTO);


    ////---------------Edit Restaurant-------------------///
    Restaurant findRestaurant(Long id);
    Object updateRstaurant(RestaurantDTO restaurantDTO);

    /*---------------Edit Menu-------------------*/
    Menu findMenu(Long id);
    Object updateMenu(MenuDTO menuDTO);

    /*---------------Boss-------------------*/

    List<UserDTO> listUser();
    UserDTO loginBoss(UserDTO userDTO);
    User deleteUser(Long id);
    /*---------------List New-------------------*/

    List<NewDTO> listNew();
    NewDTO addNew(NewDTO newDTO);

    New deleteNews(Long id);

    New findNew(Long id);

    void updateNews(NewDTO newDTO);

    NewDTO detailNews(Long id);
}
