package com.freetour.danang.services;

import com.freetour.danang.dao.models.*;
import com.freetour.danang.dao.repositories.*;
import com.freetour.danang.dto.*;
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
    private NewRepository newRepository;

    public AdminServiceImpl(CategoryRepository categoryRepository, RestaurantRepository restaurantRepository, MenuRepository menuRepository, UserRepository userRepository ,NewRepository newRepository) {
        this.categoryRepository = categoryRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
        this.newRepository = newRepository;
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
        List<Restaurant> restaurants = restaurantRepository.listStoreAdmin(id);
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
        category.setNameClass(categoryDTO.getNameClass());
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
        restaurant.setTimeOC(restaurantDTO.getTimeOC());
        restaurant.setType(restaurantDTO.getType());
        restaurant.setBanner(restaurantDTO.getBanner());
        Optional<Category> categoryOptional = categoryRepository.findById(restaurantDTO.getCategory().getId());
        //tìm thử cái id  của Restaurant có trong bảng Catelog hay không. Nếu có mới lấy nó thêm  cho cái nhà hàng được
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
        User user = userRepository.adminLogin(userDTO.getUsername(),userDTO.getPassword());
        if (user != null){
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());

            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(user.getRole().getId());
            roleDTO.setRoleName(user.getRole().getRoleName());
            userDTO.setRole(roleDTO);

            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setId(user.getRestaurantUs().getId());
            restaurantDTO.setName(user.getRestaurantUs().getName());
            userDTO.setRestaurantUs(restaurantDTO);


        }
        //List<Category> listCategory = categoryRepository.findCategory(userDTO.getRestaurantUs().getId());

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
        restaurantDTO.setTimeOC(restaurant.getTimeOC());
        restaurantDTO.setLinkMap(restaurant.getLinkMap());
        restaurantDTO.setPriceUS(restaurant.getPriceUS());
        restaurantDTO.setInfo(restaurant.getInfo());
        restaurantDTO.setShortInfo(restaurant.getShortInfo());
        restaurantDTO.setBanner(restaurant.getBanner());
        CategoryDTO categoryDTO = new CategoryDTO();
        //Set category của Nhà hàng cần hiển thị ra sẽ  là 1 cái categoryDTO hiển  thị ra (thuộc kiểu Category)
        // và categoryDTO = category trong  nhà hàng (restaurant.getCategory().getName())
        categoryDTO.setName(restaurant.getCategory().getName());
        restaurantDTO.setCategory(categoryDTO);
       /* CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(restaurant.getCategory().getName());

        restaurantDTO.setCategory(categoryDTO);*/

        return restaurantDTO;
    }
    @Override
    public Category findCategory(Long id) {
        Category category = categoryRepository.findCategory(id);
        return category;
    }
    @Override
    public void updateCategory( CategoryDTO categoryDTO) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryDTO.getId());
        if( categoryOptional.isPresent()){
            Category category =categoryOptional.get();
            category.setName(categoryDTO.getName());
            categoryRepository.save(category);
        }

    }
    //-------------Edit Restaurant--------------------//

    @Override
    public Restaurant findRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findRestaurant(id);
        return restaurant;
    }

    @Override
    public Object updateRstaurant( RestaurantDTO restaurantDTO) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantDTO.getId());
        if( restaurantOptional.isPresent()){
            Restaurant restaurant =restaurantOptional.get();
            restaurant.setName(restaurantDTO.getName());
            restaurant.setPhone(restaurantDTO.getPhone());
            restaurant.setAddress(restaurantDTO.getAddress());
            restaurant.setPriceVN(restaurantDTO.getPriceVN());
            restaurant.setPriceUS(restaurantDTO.getPriceUS());
            restaurant.setImage(restaurantDTO.getImage());
            restaurant.setTimeOC(restaurantDTO.getTimeOC());
            restaurant.setLinkMap(restaurantDTO.getLinkMap());
            restaurant.setInfo(restaurantDTO.getInfo());
            restaurant.setShortInfo(restaurantDTO.getShortInfo());
            restaurant.setType(restaurantDTO.getType());
            restaurant.setBanner(restaurantDTO.getBanner());
            Optional<Category> categoryOptional = categoryRepository.findById(restaurantDTO.getCategory().getId());
            if (categoryOptional.isPresent()){
                restaurant.setCategory(categoryOptional.get());
            }

            restaurantRepository.save(restaurant);
        }
        return null;
    }


    //-------------Edit Menu--------------------//

    @Override
    public Menu findMenu(Long id) {
        Menu menu = menuRepository.findMenu(id);
        return menu;
    }

    @Override
    public Object updateMenu( MenuDTO menuDTO) {
        Optional<Menu> menuOptional = menuRepository.findById(menuDTO.getId());
        if( menuOptional.isPresent()){
            Menu menu = menuOptional.get();
            menu.setName(menuDTO.getName());
            menu.setDescription(menuDTO.getDescription());
            menu.setPrice(menuDTO.getPrice());
            menu.setImage(menuDTO.getImage());
            menu.setFeatured(menuDTO.getFeatured());
            menu.setType(menuDTO.getType());
            Optional<Restaurant> restaurantOptional = restaurantRepository.findById(menuDTO.getRestaurant().getId());
            if (restaurantOptional.isPresent()){
                menu.setRestaurant(restaurantOptional.get());
            }
            menuRepository.save(menu);
        }
        return null;
    }


    @Override
    public MenuDTO detailMenu(Long id) {
        Menu menu = menuRepository.detailMenu(id);
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setName(menu.getName());
        menuDTO.setDescription(menu.getDescription());
        menuDTO.setPrice(menu.getPrice());
        menuDTO.setImage(menu.getImage());
        menuDTO.setFeatured(menu.getFeatured());
        menuDTO.setType(menu.getType());

        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setName(menu.getRestaurant().getName());

        menuDTO.setRestaurant(restaurantDTO);

        return menuDTO;
    }

    @Override
    public List<UserDTO> listUser() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users =userRepository.findUser();
        for (User user:users){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public UserDTO loginBoss(UserDTO userDTO) {
        User user = userRepository.bossLogin(userDTO.getUsername(),userDTO.getPassword());
        if (user != null){
            userDTO.setId(user.getId());
        }
        return userDTO;
    }

    @Override
    public User deleteUser(Long id) {
        userRepository.deleteById(id);
        return null;
    }
    /*---------------List New-------------------*/

    @Override
    public List<NewDTO> listNew() {
        List<NewDTO> newDTOS = new ArrayList<>();
        List<New> news = newRepository.findAll();
        for (New  aNew :news){
            NewDTO newDTO = new NewDTO();
            newDTO.setId(aNew.getId());
            newDTO.setNewTitle(aNew.getNewTitle());
            newDTO.setShortInfor(aNew.getShortInfor());
            newDTO.setInfor(aNew.getInfor());
            newDTO.setLinkImage(aNew.getLinkImage());
            newDTO.setSourceAuthor(aNew.getSourceAuthor());
            newDTO.setDate(aNew.getDate());
            newDTOS.add(newDTO);
        }
        return newDTOS;
    }

    @Override
    public NewDTO addNew(NewDTO newDTO) {
        New aNew = new New();
        aNew.setNewTitle(newDTO.getNewTitle());
        aNew.setInfor(newDTO.getInfor());
        aNew.setShortInfor(newDTO.getShortInfor());
        aNew.setLinkImage(newDTO.getLinkImage());
        aNew.setSourceAuthor(newDTO.getSourceAuthor());
        aNew.setDate(newDTO.getDate());
        newRepository.save(aNew);
        return null;
    }

    @Override
    public New deleteNews(Long id) {
        newRepository.deleteById(id);
        return null;
    }

    @Override
    public New findNew(Long id) {
        New news = newRepository.findNew(id);
        return news;
    }

    @Override
    public void updateNews(NewDTO newDTO) {
        Optional<New> newOptional = newRepository.findById(newDTO.getId());
        if( newOptional.isPresent()){
            New aNew = newOptional.get();
            aNew.setNewTitle(newDTO.getNewTitle());
            aNew.setInfor(newDTO.getInfor());
            aNew.setShortInfor(newDTO.getShortInfor());
            aNew.setSourceAuthor(newDTO.getSourceAuthor());
            aNew.setDate(newDTO.getDate());
            aNew.setLinkImage(newDTO.getLinkImage());
            newRepository.save(aNew);
        }
    }

    @Override
    public NewDTO detailNews(Long id) {
        New aNew = newRepository.findNew(id);
        NewDTO newDTO = new NewDTO();
        newDTO.setId(aNew.getId());
        newDTO.setNewTitle(aNew.getNewTitle());
        newDTO.setInfor(aNew.getInfor());
        newDTO.setSourceAuthor(aNew.getSourceAuthor());
        newDTO.setShortInfor(aNew.getShortInfor());
        newDTO.setDate(aNew.getDate());
        newDTO.setLinkImage(aNew.getLinkImage());

        return newDTO;
    }
}