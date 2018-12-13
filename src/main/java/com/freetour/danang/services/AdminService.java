package com.freetour.danang.services;

import com.freetour.danang.dao.models.Category;
import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dao.models.Restaurant;
import com.freetour.danang.dto.CategoryDTO;
import com.freetour.danang.dto.MenuDTO;
import com.freetour.danang.dto.RestaurantDTO;
import com.freetour.danang.dto.UserDTO;

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
}
