package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.BookingTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingTourRepository extends JpaRepository<BookingTour,Long> {
    @Query(value = "SELECT * FROM bookingtour WHERE tour_id  = ?1", nativeQuery = true)

    BookingTour findBookingTour(Long id);
}
