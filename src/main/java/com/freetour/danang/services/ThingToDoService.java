package com.freetour.danang.services;

import com.freetour.danang.dao.models.Category;
import com.freetour.danang.dao.models.Restaurant;
import com.freetour.danang.dto.CategoryDTO;
import com.freetour.danang.dto.MenuDTO;
import com.freetour.danang.dto.RestaurantDTO;

import java.util.List;

public interface ThingToDoService {




    RestaurantDTO getPartNer(Long id);

    List<MenuDTO> getPartNerMenu(Long id);

    MenuDTO getFeatured(Long id);

    List<RestaurantDTO> getMenuRes(Long id);

    List<MenuDTO> getMenuFood(Long id);

    List<MenuDTO> getMenuDrink(Long id);

    List<CategoryDTO> getListThingToDo();

    List<RestaurantDTO> listStore(Long id);
}
