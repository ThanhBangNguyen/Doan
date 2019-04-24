package com.freetour.danang.services;

import com.freetour.danang.dto.NewDTO;
import java.util.List;

public interface NewService {
    NewDTO findNew();

    List<NewDTO> listNew();

    NewDTO readNews(Long id);

    int countNew();

    int countCategory();

    int countRestaurant();

    int countMenu();
}
