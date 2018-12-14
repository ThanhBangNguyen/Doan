package com.freetour.danang.services;

import com.freetour.danang.dao.models.Category;
import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dao.models.Restaurant;
import com.freetour.danang.dao.repositories.CategoryRepository;
import com.freetour.danang.dao.repositories.MenuRepository;
import com.freetour.danang.dao.repositories.RestaurantRepository;
import com.freetour.danang.dto.CategoryDTO;
import com.freetour.danang.dto.MenuDTO;
import com.freetour.danang.dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThingToDoServiceImpl implements ThingToDoService{
    private RestaurantRepository restaurantRepository;
    private CategoryRepository categoryRepository;
    private MenuRepository menuRepository;

    public ThingToDoServiceImpl(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<CategoryDTO> getListThingToDo() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category:categories){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTO.setNameClass(category.getNameClass());
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public List<RestaurantDTO> listStore(Long id) {
        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        List<Restaurant> restaurants = restaurantRepository.listStore(id);
        for (Restaurant restaurant:restaurants){
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setId(restaurant.getId());
            restaurantDTO.setName(restaurant.getName());
            restaurantDTO.setImage(restaurant.getImage());
            restaurantDTO.setShortInfo(restaurant.getShortInfo());
            restaurantDTO.setPriceUS(restaurant.getPriceUS());
            restaurantDTO.setPriceVN(restaurant.getPriceVN());
            restaurantDTOS.add(restaurantDTO);
        }
        return restaurantDTOS;
    }





    @Override
    public RestaurantDTO getPartNer(Long id) {
        Restaurant restaurant = restaurantRepository.listById(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setInfo(restaurant.getInfo());
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setImage(restaurant.getImage());
        restaurantDTO.setOpenCloseTime(restaurant.getTimeOC());
        restaurantDTO.setPriceUS(restaurant.getPriceUS());
        restaurantDTO.setPriceVN(restaurant.getPriceVN());
        restaurantDTO.setPhone(restaurant.getPhone());
        restaurantDTO.setType(restaurant.getType());
        restaurantDTO.setLinkMap(restaurant.getLinkMap());

        return restaurantDTO;
    }

    @Override
    public List<MenuDTO> getPartNerMenu(Long id) {
        List<MenuDTO> list = new ArrayList<>();
        List<Menu> menus = menuRepository.listById(id);
        for (Menu menu: menus){
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setId(menu.getId());
            menuDTO.setName(menu.getName());
            menuDTO.setImage(menu.getImage());
            menuDTO.setDescription(menu.getDescription());
            menuDTO.setPrice(menu.getPrice());
            menuDTO.setFeatured(menu.getFeatured());

            list.add(menuDTO);
        }
        return list;
    }

    @Override
    public MenuDTO getFeatured(Long id) {
        Menu menu = menuRepository.getFeatured(id);
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setName(menu.getName());
        menuDTO.setImage(menu.getImage());
        menuDTO.setDescription(menu.getDescription());
        menuDTO.setPrice(menu.getPrice());

        return menuDTO;
    }

    @Override
    public List<RestaurantDTO> getMenuRes(Long id) {
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        List<Restaurant> restaurants = restaurantRepository.findMenu(id);
        for (Restaurant restaurant:restaurants){
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setId(restaurant.getId());
            restaurantDTO.setName(restaurant.getName());
            restaurantDTO.setImage(restaurant.getImage());
            restaurantDTO.setShortInfo(restaurant.getShortInfo());
            restaurantDTO.setPriceUS(restaurant.getPriceUS());
            restaurantDTO.setPriceVN(restaurant.getPriceVN());
            restaurantDTOList.add(restaurantDTO);
        }
        return restaurantDTOList;
    }


    @Override
    public List<MenuDTO> getMenuFood(Long id) {
        List<MenuDTO> list = new ArrayList<>();
        List<Menu> menus = menuRepository.listByIdEAT(id);
        for (Menu menu: menus){
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setId(menu.getId());
            menuDTO.setName(menu.getName());
            menuDTO.setImage(menu.getImage());
            menuDTO.setDescription(menu.getDescription());
            menuDTO.setPrice(menu.getPrice());
            menuDTO.setFeatured(menu.getFeatured());

            list.add(menuDTO);
        }
        return list;
    }
    @Override
    public List<MenuDTO> getMenuDrink(Long id) {
        List<MenuDTO> list = new ArrayList<>();
        List<Menu> menus = menuRepository.listByIdDrink(id);
        for (Menu menu: menus){
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setId(menu.getId());
            menuDTO.setName(menu.getName());
            menuDTO.setImage(menu.getImage());
            menuDTO.setDescription(menu.getDescription());
            menuDTO.setPrice(menu.getPrice());
            menuDTO.setFeatured(menu.getFeatured());

            list.add(menuDTO);
        }
        return list;
    }
}
