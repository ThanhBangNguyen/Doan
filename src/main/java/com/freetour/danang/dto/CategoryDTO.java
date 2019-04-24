package com.freetour.danang.dto;

import com.freetour.danang.dao.models.Restaurant;

import java.util.List;

public class CategoryDTO {
    private Long id;
    private String name;
    private String nameClass;
    private List<RestaurantDTO> restaurants;
    private  List<RelaxDTO> relaxs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RestaurantDTO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantDTO> restaurants) {
        this.restaurants = restaurants;
    }

    public List<RelaxDTO> getRelaxs() {
        return relaxs;
    }

    public void setRelaxs(List<RelaxDTO> relaxs) {
        this.relaxs = relaxs;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
