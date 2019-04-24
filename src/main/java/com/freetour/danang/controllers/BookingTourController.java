package com.freetour.danang.controllers;

import com.freetour.danang.dto.BookingTourDTO;
import com.freetour.danang.services.BookingTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@RestController
public class BookingTourController {
    @Autowired
    private BookingTourService bookingTourService;
   /* @GetMapping(value = "/bookingTour")
    public ModelAndView bookingTour(HttpSession session){
        ModelAndView mav = new ModelAndView();
        mav.addObject("bookingTour",new BookingTourDTO());
        mav.setViewName("/bookingTour");
        return mav;
    }*/
   @GetMapping(value = "/bookingTour")
   public ModelAndView bookingTour(HttpSession session){
       ModelAndView mav = new ModelAndView();
       mav.addObject("bookingTour",new BookingTourDTO());
       mav.setViewName("admin/bookTour");
       return mav;
   }
    @PostMapping(value = "/bookingTour-Process")
    public ModelAndView bookingTourProcess(BookingTourDTO bookingTourDTO){
        ModelAndView mav = new ModelAndView();

            bookingTourService.bookingTour(bookingTourDTO);
            mav.setViewName("redirect:/");

        return mav;
    }

    @GetMapping(value = "/admin/listTours")
    public ModelAndView listTours(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("listTours",bookingTourService.listTours());
        mav.setViewName("admin/listTours");
        return mav;
    }
    @GetMapping(value = "/admin/deleteTour/{id}")
    public ModelAndView deleteTour(@PathVariable(value = "id") Long id){
        ModelAndView mav = new ModelAndView();
        bookingTourService.deleteTour(id);
        mav.setViewName("redirect:/admin/listTours");
        return mav;
    }
    @GetMapping(value = "/admin/detailTour-{id}")
    public ModelAndView detailTour(@PathVariable(value = "id") Long id, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin/login");
            return mav;
        }
        mav.addObject("detailTour",bookingTourService.detailTour(id));
        mav.setViewName("admin/detailTour");
        return mav;
    }
}
