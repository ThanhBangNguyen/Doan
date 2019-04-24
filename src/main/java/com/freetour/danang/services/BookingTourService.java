package com.freetour.danang.services;

import com.freetour.danang.dto.BookingTourDTO;


import java.util.List;

public interface BookingTourService {
    void bookingTour(BookingTourDTO bookingTourDTO);

    List<BookingTourDTO> listTours();

    void deleteTour(Long id);

    BookingTourDTO detailTour(Long id);
}
