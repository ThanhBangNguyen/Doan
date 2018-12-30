package com.freetour.danang.services;

import com.freetour.danang.dao.models.Category;
import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dao.models.New;
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


    public NewServiceImpl( NewRepository newRepository) {
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
}
