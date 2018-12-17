package com.freetour.danang.dto;

import java.util.List;

public class RestaurantDTO {
    private Long id;
    private String name;
    private String priceUS;
    private String priceVN;
    private String info;
    private String shortInfo;
    private String address;
    private String openCloseTime;
    private String phone;
    private String linkMap;
    private String image;
    private String video;
    private Integer type;
    private Boolean featured;
    private List<MenuDTO> menus;
    private CategoryDTO category;

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priceUS='" + priceUS + '\'' +
                ", priceVN='" + priceVN + '\'' +
                ", info='" + info + '\'' +
                ", shortInfo='" + shortInfo + '\'' +
                ", address='" + address + '\'' +
                ", openCloseTime='" + openCloseTime + '\'' +
                ", phone='" + phone + '\'' +
                ", linkMap='" + linkMap + '\'' +
                ", image='" + image + '\'' +
                ", video='" + video + '\'' +
                ", type=" + type +
                ", featured=" + featured +
                ", menus=" + menus +
                ", category=" + category +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceUS() {
        return priceUS;
    }

    public void setPriceUS(String priceUS) {
        this.priceUS = priceUS;
    }

    public String getPriceVN() {
        return priceVN;
    }

    public void setPriceVN(String priceVN) {
        this.priceVN = priceVN;
    }

    public List<MenuDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDTO> menus) {
        this.menus = menus;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenCloseTime() {
        return openCloseTime;
    }

    public void setOpenCloseTime(String openCloseTime) {
        this.openCloseTime = openCloseTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkMap() {
        return linkMap;
    }

    public void setLinkMap(String linkMap) {
        this.linkMap = linkMap;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
