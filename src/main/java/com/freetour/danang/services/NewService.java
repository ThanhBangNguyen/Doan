package com.freetour.danang.services;


import com.freetour.danang.dao.models.New;
import com.freetour.danang.dto.CategoryDTO;
import com.freetour.danang.dto.NewDTO;

import java.util.List;

public interface NewService {
   NewDTO findNew();

   List<NewDTO> listNew();

    NewDTO readNews(Long id);
}
