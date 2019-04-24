package com.freetour.danang.services;


import com.freetour.danang.dto.*;

import java.util.List;

public interface ThingToDoService {



    List<MenuDTO> getPartNerMenu(Long id);

    List<RestaurantDTO> getMenuRes(Long id);

    List<MenuDTO> getMenuFood(Long id);

    List<MenuDTO> getMenuDrink(Long id);

    List<CategoryDTO> getListThingToDo();

    List<RestaurantDTO> listStore(Long id);

    List<RelaxDTO> getListRelax(Long id);

    List<MenuRelaxDTO> getMenuRelax(Long id);

    RestaurantDTO getPartNer(Long id);

    MenuDTO getFeatured(Long id);

    RelaxDTO getInforRelax(Long id);
}
