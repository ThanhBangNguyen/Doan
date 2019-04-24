package com.freetour.danang.dto;

public class MenuRelaxDTO {
    private Long id;
    private String name;
    private Double price;
    private String infor;
    private RelaxDTO relax;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public RelaxDTO getRelax() {
        return relax;
    }

    public void setRelax(RelaxDTO relax) {
        this.relax = relax;
    }
}
