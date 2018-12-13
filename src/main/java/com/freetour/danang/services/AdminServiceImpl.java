package com.freetour.danang.services;

import com.freetour.danang.dao.models.Category;
import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dao.models.Restaurant;
import com.freetour.danang.dao.models.User;
import com.freetour.danang.dao.repositories.CategoryRepository;
import com.freetour.danang.dao.repositories.MenuRepository;
import com.freetour.danang.dao.repositories.RestaurantRepository;
import com.freetour.danang.dao.repositories.UserRepository;
import com.freetour.danang.dto.CategoryDTO;
import com.freetour.danang.dto.MenuDTO;
import com.freetour.danang.dto.RestaurantDTO;
import com.freetour.danang.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private CategoryRepository categoryRepository;
    private RestaurantRepository restaurantRepository;
    private MenuRepository menuRepository;
    private UserRepository userRepository;

    public AdminServiceImpl(CategoryRepository categoryRepository, RestaurantRepository restaurantRepository, MenuRepository menuRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CategoryDTO> listThingToDo() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category:categories){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());

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
            restaurantDTO.setPriceVN(restaurant.getPriceVN());
            restaurantDTO.setAddress(restaurant.getAddress());
            restaurantDTO.setPhone(restaurant.getPhone());
            restaurantDTOS.add(restaurantDTO);
        }
        return restaurantDTOS;
    }

    @Override
    public List<MenuDTO> listMenu(Long id) {
        List<MenuDTO> menuDTOS =new ArrayList<>();
        List<Menu> menus = menuRepository.listMenu(id);
        for (Menu menu:menus){
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setId(menu.getId());
            menuDTO.setName(menu.getName());
            menuDTO.setPrice(menu.getPrice());
            menuDTO.setFeatured(menu.getFeatured());
            menuDTOS.add(menuDTO);
        }
        return menuDTOS;
    }

    @Override
    public CategoryDTO addThingToDo(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
        return null;
    }

    @Override
    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setPhone(restaurantDTO.getPhone());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setImage(restaurantDTO.getImage());
        restaurant.setInfo(restaurantDTO.getInfo());
        restaurant.setLinkMap(restaurantDTO.getLinkMap());
        restaurant.setPriceUS(restaurantDTO.getPriceUS());
        restaurant.setPriceVN(restaurantDTO.getPriceVN());
        restaurant.setShortInfo(restaurantDTO.getShortInfo());
        restaurant.setTimeOC(restaurantDTO.getOpenCloseTime());
        restaurant.setType(restaurantDTO.getType());
        Optional<Category> categoryOptional = categoryRepository.findById(restaurantDTO.getCategory().getId());
        if (categoryOptional.isPresent()){
            restaurant.setCategory(categoryOptional.get());
        }
        restaurantRepository.save(restaurant);
        return null;
    }

    @Override
    public MenuDTO addMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setName(menuDTO.getName());
        menu.setImage(menuDTO.getImage());
        menu.setDescription(menuDTO.getDescription());
        menu.setFeatured(menuDTO.getFeatured());
        menu.setPrice(menuDTO.getPrice());
        menu.setType(menuDTO.getType());
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(menuDTO.getRestaurant().getId());
        if (restaurantOptional.isPresent()){
            menu.setRestaurant(restaurantOptional.get());
        }
        menuRepository.save(menu);
        return null;
    }

    @Override
    public List<RestaurantDTO> listRes() {
        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        List<Restaurant> restaurants = restaurantRepository.findAll();
        for (Restaurant restaurant:restaurants){
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setId(restaurant.getId());
            restaurantDTO.setName(restaurant.getName());
            restaurantDTOS.add(restaurantDTO);
        }
        return restaurantDTOS;
    }

    @Override
    public Category deleteThingToDo(Long id) {
        categoryRepository.deleteById(id);
        return null;
    }

    @Override
    public Restaurant deleteStore(Long id) {
        restaurantRepository.deleteById(id);
        return null;
    }

    @Override
    public Menu deleteMenu(Long id) {
        menuRepository.deleteById(id);
        return null;
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        User user = userRepository.findByAdmin(userDTO.getUsername(),userDTO.getPassword());
        if (user != null){
            userDTO.setId(user.getId());
        }
        return userDTO;
    }

    @Override
    public RestaurantDTO detailStore(Long id) {
        Restaurant restaurant = restaurantRepository.detailStore(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setPhone(restaurant.getPhone());
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setPriceVN(restaurant.getPriceVN());
        restaurantDTO.setImage(restaurant.getImage());
        restaurantDTO.setOpenCloseTime(restaurant.getTimeOC());
        restaurantDTO.setLinkMap(restaurant.getLinkMap());
        restaurantDTO.setPriceUS(restaurant.getPriceUS());
        restaurantDTO.setInfo(restaurant.getInfo());
        restaurantDTO.setShortInfo(restaurant.getShortInfo());

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(restaurant.getCategory().getName());

        restaurantDTO.setCategory(categoryDTO);

        return restaurantDTO;
    }
}