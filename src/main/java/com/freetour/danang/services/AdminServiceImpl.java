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
    @Autowired RelaxRepository relaxRepository;
    @Autowired MenuRelaxRepository menuRelaxRepository;
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
    /*=-----------------------------------------------Category-----------------------------------------------------=*/
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
    public void addThingToDo(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setNameClass(categoryDTO.getNameClass());
        categoryRepository.save(category);

    }

    @Override
    public void deleteThingToDo(Long id) {
        categoryRepository.deleteById(id);

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


    /*=-----------------------------------------------Restaurant-----------------------------------------------------=*/
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


            List<MenuDTO> menuDTOS =new ArrayList<>();
            List<Menu> menus = menuRepository.listMenu(restaurantDTO.getId());
            for (Menu menu:menus){
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setId(menu.getId());
                menuDTO.setName(menu.getName());
                menuDTO.setPrice(menu.getPrice());
                menuDTO.setFeatured(menu.getFeatured());
                menuDTOS.add(menuDTO);
            }
            restaurantDTO.setMenus(menuDTOS);

            restaurantDTOS.add(restaurantDTO);

        }
        return restaurantDTOS;
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
    public void addRestaurant(RestaurantDTO restaurantDTO) {
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
        //tìm thử cái id  của RestaurantDTO.getCategory.Id có trong bảng Catelog hay không. Nếu có mới lấy nó thêm  cho cái nhà hàng được
        if (categoryOptional.isPresent()){
            restaurant.setCategory(categoryOptional.get());
        }
        restaurantRepository.save(restaurant);

    }

    @Override
    public void deleteStore(Long id) {
        restaurantRepository.deleteById(id);

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

        return restaurantDTO;
    }

    @Override
    public Restaurant findRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findRestaurant(id);
        return restaurant;
    }

    @Override
    public void updateRstaurant( RestaurantDTO restaurantDTO) {
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

    }

    @Override
    public Long count() {

        int count = 0 ;
        List<Category> categories = categoryRepository.findAll();
        for (Category category:categories){
            count  = count +1;
        }

        return count();
    }

    /*=-----------------------------------------------Menu-----------------------------------------------------=*/

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
    public void addMenu(MenuDTO menuDTO) {
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

    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
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
    public Menu findMenu(Long id) {
        Menu menu = menuRepository.findMenu(id);
        return menu;
    }

    @Override
    public void updateMenu( MenuDTO menuDTO) {
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

    }

    /*=-----------------------------------------------Relax-----------------------------------------------------=*/

    @Override
    public List<RelaxDTO> ListRelax() {
        List<RelaxDTO> relaxDTOS = new ArrayList<>();
        List<Relax> relaxes = relaxRepository.findAll();
        for (Relax relax:relaxes){
            RelaxDTO relaxDTO = new RelaxDTO();
            relaxDTO.setId(relax.getId());
            relaxDTO.setName(relax.getName());
            relaxDTOS.add(relaxDTO);
        }
        return relaxDTOS;
    }

    @Override
    public void addRelax(RelaxDTO relaxDTO) {
        Relax relax = new Relax();
        relax.setName(relaxDTO.getName());
        relax.setInfor(relaxDTO.getInfor());
        relax.setAddress(relaxDTO.getAddress());
        relax.setPriceUS(relaxDTO.getPriceUS());
        relax.setPriceVN(relaxDTO.getPriceVN());
        relax.setImage(relaxDTO.getImage());
        relax.setPhone(relaxDTO.getPhone());

        Optional<Category> categoryOptional = categoryRepository.findById(relaxDTO.getCategoryRL().getId());

        if (categoryOptional.isPresent()){
            relax.setCategoryRL(categoryOptional.get());
        }
        relaxRepository.save(relax);

    }





    @Override
    public void deleteRelax(Long id) {
        relaxRepository.deleteById(id);

    }

    @Override
    public RelaxDTO detailRelax(Long id) {
        Relax relax = relaxRepository.detailRelax(id);
        RelaxDTO relaxDTO = new RelaxDTO();
        relaxDTO.setName(relax.getName());
        relaxDTO.setInfor(relax.getInfor());
        relaxDTO.setAddress(relax.getAddress());
        relaxDTO.setPriceVN(relax.getPriceVN());
        relaxDTO.setImage(relax.getImage());
        relaxDTO.setPhone(relax.getPhone());
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(relax.getCategoryRL().getName());
        relaxDTO.setCategoryRL(categoryDTO);
        return relaxDTO;
    }

    @Override
    public Relax findRelax(Long id) {
        Relax relax = relaxRepository.findRelax(id);
        return relax;

    }

    @Override
    public void updateRelax(RelaxDTO relaxDTO) {
        Optional<Relax> relaxOptional = relaxRepository.findById(relaxDTO.getId());
        if( relaxOptional.isPresent()){
            Relax relax =relaxOptional.get();
            relax.setName(relaxDTO.getName());
            relax.setInfor(relaxDTO.getInfor());
            relax.setAddress(relaxDTO.getAddress());
            relax.setPriceVN(relaxDTO.getPriceVN());
            relax.setPriceUS(relaxDTO.getPriceUS());
            relax.setImage(relaxDTO.getImage());
            relax.setPhone(relaxDTO.getPhone());
            Optional<Category> categoryOptional = categoryRepository.findById(relaxDTO.getCategoryRL().getId());
            if (categoryOptional.isPresent()){
                relax.setCategoryRL(categoryOptional.get());
            }

            relaxRepository.save(relax);
        }

    }

    /*---------------------------------------Menu Relax Admin----------------------------------------------------*/
    @Override
    public void addMenuRelax(MenuRelaxDTO menuRelaxDTO) {
        MenuRelax menuRelax = new MenuRelax();
        menuRelax.setName(menuRelaxDTO.getName());
        menuRelax.setPrice(menuRelaxDTO.getPrice());
        menuRelax.setInfor(menuRelaxDTO.getInfor());
        Optional<Relax> relaxOptional = relaxRepository.findById(menuRelaxDTO.getRelax().getId());
        if (relaxOptional.isPresent()){
            menuRelax.setRelax(relaxOptional.get());
        }
        menuRelaxRepository.save(menuRelax);

    }

    @Override
    public void deleteMenuRelax(Long id) {
        menuRelaxRepository.deleteById(id);

    }

    @Override
    public MenuRelaxDTO detailMenuRelax(Long id) {
        MenuRelax menuRelax = menuRelaxRepository.findMenuRelax(id);
        MenuRelaxDTO menuRelaxDTO = new MenuRelaxDTO();
        menuRelaxDTO.setId(menuRelax.getId());
        menuRelaxDTO.setName(menuRelax.getName());

        menuRelaxDTO.setPrice(menuRelax.getPrice());
        menuRelaxDTO.setInfor(menuRelax.getInfor());

        RelaxDTO relaxDTO = new RelaxDTO();
        relaxDTO.setName(menuRelax.getRelax().getName());

        menuRelaxDTO.setRelax(relaxDTO);

        return menuRelaxDTO;
    }

    @Override
    public MenuRelax findMenuRelax(Long id) {
        MenuRelax menuRelax = menuRelaxRepository.findMenuRelax(id);
        return menuRelax;
    }

    @Override
    public void updateMenuRelax(MenuRelaxDTO menuRelaxDTO) {
        Optional<MenuRelax> menuRelaxOptional = menuRelaxRepository.findById(menuRelaxDTO.getId());
        if( menuRelaxOptional.isPresent()){
            MenuRelax menuRelax = menuRelaxOptional.get();
            menuRelax.setName(menuRelaxDTO.getName());
            menuRelax.setPrice(menuRelaxDTO.getPrice());
            menuRelax.setInfor(menuRelaxDTO.getInfor());

            Optional<Relax> relaxOptional = relaxRepository.findById(menuRelaxDTO.getRelax().getId());
            if (relaxOptional.isPresent()){
                menuRelax.setRelax(relaxOptional.get());
            }
            menuRelaxRepository.save(menuRelax);
        }


    }
    /*----------------------------------------------------------------------------------------------------*/

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
        return userDTO;
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
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    /*-------------------------------------------- New Admin----------------------------------------------------*/

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
    public void addNew(NewDTO newDTO) {
        New aNew = new New();
        aNew.setNewTitle(newDTO.getNewTitle());
        aNew.setInfor(newDTO.getInfor());
        aNew.setShortInfor(newDTO.getShortInfor());
        aNew.setLinkImage(newDTO.getLinkImage());
        aNew.setSourceAuthor(newDTO.getSourceAuthor());
        aNew.setDate(newDTO.getDate());
        newRepository.save(aNew);

    }

    @Override
    public void deleteNews(Long id) {
        newRepository.deleteById(id);

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