package com.freetour.danang.services;

import com.freetour.danang.dao.models.Category;
import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dao.models.New;
import com.freetour.danang.dao.models.Restaurant;
import com.freetour.danang.dao.repositories.*;
import com.freetour.danang.dto.CategoryDTO;
import com.freetour.danang.dto.MenuDTO;
import com.freetour.danang.dto.NewDTO;
import com.freetour.danang.dto.RestaurantDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewServiceImpl implements NewService {

    private NewRepository newRepository;
    private RestaurantRepository restaurantRepository;
    private CategoryRepository categoryRepository;
    private MenuRepository menuRepository;
    private RelaxRepository relaxRepository;
    private MenuRelaxRepository menuRelaxRepository;

    public NewServiceImpl(NewRepository newRepository,MenuRelaxRepository menuRelaxRepository,RestaurantRepository restaurantRepository, CategoryRepository categoryRepository, MenuRepository menuRepository,RelaxRepository relaxRepository) {
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
        this.menuRepository = menuRepository;
        this.relaxRepository = relaxRepository;
        this.menuRelaxRepository = menuRelaxRepository;
        this.newRepository = newRepository;
    }

    @Override
    public NewDTO findNew() {
        New aNew  = newRepository.findNewsOne();
        NewDTO newDTO = new NewDTO();
        newDTO.setId(aNew.getId());
        newDTO.setNewTitle(aNew.getNewTitle());
        newDTO.setShortInfor(aNew.getShortInfor());
        newDTO.setInfor(aNew.getInfor());
        newDTO.setLinkImage(aNew.getLinkImage());
        newDTO.setSourceAuthor(aNew.getSourceAuthor());
        newDTO.setDate(aNew.getDate());


        return newDTO;
    }

    @Override
    public List<NewDTO> listNew() {
        List<NewDTO> newDTOS = new ArrayList<>();
        List<New> news = newRepository.findAll();
        for (New  aNew :news){
            NewDTO newDTO = new NewDTO();
            newDTO.setId(aNew.getId());
            newDTO.setNewTitle(aNew.getNewTitle());
            newDTO.setShortInfor(aNew.getShortInfor());
            newDTO.setClasses(aNew.getClasses());
            newDTO.setBackground(aNew.getBackground());
            newDTO.setInfor(aNew.getInfor());
            newDTO.setLinkImage(aNew.getLinkImage());
            newDTO.setSourceAuthor(aNew.getSourceAuthor());
            newDTO.setDate(aNew.getDate());
            newDTOS.add(newDTO);
        }
        return newDTOS;
    }
    @Override
    public NewDTO readNews(Long id) {
        New aNew  = newRepository.findNew(id);
        NewDTO newDTO = new NewDTO();
        newDTO.setId(aNew.getId());
        newDTO.setNewTitle(aNew.getNewTitle());
        newDTO.setShortInfor(aNew.getShortInfor());
        newDTO.setInfor(aNew.getInfor());
        newDTO.setLinkImage(aNew.getLinkImage());
        newDTO.setSourceAuthor(aNew.getSourceAuthor());
        newDTO.setDate(aNew.getDate());


        return newDTO;
    }

    @Override
    public int countNew() {
        int countNew = 0;
        List<New> news = newRepository.findAll();
        for (New  aNew :news){
            countNew = countNew+1;
        }
        return countNew;
    }

    @Override
    public int countCategory() {
        int countCategory = 0;
        List<Category> categories = categoryRepository.findAll();
        for (Category  category :categories){
            countCategory = countCategory+1;
        }
        return countCategory;
    }

    @Override
    public int countRestaurant() {
        int countRestaurant = 0;
        List<Restaurant> restaurants = restaurantRepository.findAll();
        for (Restaurant  restaurant :restaurants){
            countRestaurant = countRestaurant+1;
        }
        return countRestaurant;
    }

    @Override
    public int countMenu() {
        int countMenu = 0;
        List<Menu> menus = menuRepository.findAll();
        for (Menu  menu :menus){
            countMenu = countMenu+1;
        }
        return countMenu;
    }


}
