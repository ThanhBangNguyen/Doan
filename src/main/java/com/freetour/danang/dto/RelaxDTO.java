package com.freetour.danang.dto;

import java.util.List;


public class RelaxDTO {

    private Long id;
    private String name;
    private String infor;
    private String priceUS;
    private String priceVN;
    private String address;
    private String image;
    private String phone;
    private CategoryDTO categoryRL;
    private List<MenuRelaxDTO>  menuRelaxes;

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

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CategoryDTO getCategoryRL() {
        return categoryRL;
    }

    public void setCategoryRL(CategoryDTO categoryRL) {
        this.categoryRL = categoryRL;
    }

    public List<MenuRelaxDTO> getMenuRelaxes() {
        return menuRelaxes;
    }

    public void setMenuRelaxes(List<MenuRelaxDTO> menuRelaxes) {
        this.menuRelaxes = menuRelaxes;
    }
}
