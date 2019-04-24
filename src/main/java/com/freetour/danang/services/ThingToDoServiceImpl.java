package com.freetour.danang.services;

import com.freetour.danang.dao.models.*;
import com.freetour.danang.dao.repositories.*;
import com.freetour.danang.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThingToDoServiceImpl implements ThingToDoService{
    private RestaurantRepository restaurantRepository;
    private CategoryRepository categoryRepository;
    private MenuRepository menuRepository;
    private RelaxRepository relaxRepository;
    private MenuRelaxRepository menuRelaxRepository;

    public ThingToDoServiceImpl(MenuRelaxRepository menuRelaxRepository,RestaurantRepository restaurantRepository, CategoryRepository categoryRepository, MenuRepository menuRepository,RelaxRepository relaxRepository) {
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
        this.menuRepository = menuRepository;
        this.relaxRepository = relaxRepository;
        this.menuRelaxRepository = menuRelaxRepository;
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

        Restaurant restaurant = restaurantRepository.findRestaurant(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setInfo(restaurant.getInfo());
        restaurantDTO.setShortInfo(restaurant.getShortInfo());
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setImage(restaurant.getImage());
        restaurantDTO.setTimeOC(restaurant.getTimeOC());
        restaurantDTO.setPriceUS(restaurant.getPriceUS());
        restaurantDTO.setPriceVN(restaurant.getPriceVN());
        restaurantDTO.setPhone(restaurant.getPhone());
        restaurantDTO.setType(restaurant.getType());
        restaurantDTO.setLinkMap(restaurant.getLinkMap());
        restaurantDTO.setVideo(restaurant.getVideo());
        restaurantDTO.setBanner(restaurant.getBanner());

        return restaurantDTO;
    }



    @Override
    public RelaxDTO getInforRelax(Long id) {
        Relax relax = relaxRepository.findRelax(id);

        RelaxDTO relaxDTO = new RelaxDTO();
        relaxDTO.setId(relax.getId());
        relaxDTO.setName(relax.getName());
        relaxDTO.setInfor(relax.getInfor());
        relaxDTO.setAddress(relax.getAddress());
        relaxDTO.setPriceUS(relax.getPriceUS());
        relaxDTO.setPriceVN(relax.getPriceVN());
        relaxDTO.setImage(relax.getImage());
        relaxDTO.setPhone(relax.getPhone());

        return relaxDTO;
    }

    @Override
    public List<RelaxDTO> getListRelax(Long id) {
        List<RelaxDTO> relaxDTOList = new ArrayList<>();
        List<Relax> relaxes = relaxRepository.listRelax(id);

        for (Relax relax: relaxes){
            RelaxDTO relaxDTO = new RelaxDTO();
            relaxDTO.setId(relax.getId());
            relaxDTO.setName(relax.getName());
            relaxDTO.setInfor(relax.getInfor());
            relaxDTO.setAddress(relax.getAddress());
            relaxDTO.setPriceUS(relax.getPriceUS());
            relaxDTO.setPriceVN(relax.getPriceVN());
            relaxDTO.setImage(relax.getImage());
            relaxDTO.setPhone(relax.getPhone());
            relaxDTOList.add(relaxDTO);
        }
        return relaxDTOList;
    }

    @Override
    public List<MenuDTO> getPartNerMenu(Long id) {
        List<MenuDTO> list = new ArrayList<>();
        List<Menu> menus = menuRepository.listMenuById(id);
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
        List<Menu> menus = menuRepository.listByIdEat(id);
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
    public List<MenuRelaxDTO> getMenuRelax(Long id) {
        List<MenuRelaxDTO> menuRelaxDTOList = new ArrayList<>();
        List<MenuRelax> menuRelaxes = menuRelaxRepository.MenuRelax(id);
        for (MenuRelax menuRelax: menuRelaxes){
            MenuRelaxDTO menuRelaxDTO = new MenuRelaxDTO();
            menuRelaxDTO.setId(menuRelax.getId());
            menuRelaxDTO.setName(menuRelax.getName());
            menuRelaxDTO.setInfor(menuRelax.getInfor());
            menuRelaxDTO.setPrice(menuRelax.getPrice());

            menuRelaxDTOList.add(menuRelaxDTO);
        }
        return menuRelaxDTOList;
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
