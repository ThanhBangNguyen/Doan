package com.freetour.danang.dao.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menu_relax")
public class MenuRelax implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_relax")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "infor")
    private String infor;


    @ManyToOne
    @JoinColumn(name = "id_relax")
    private Relax relax ;

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

    public Relax getRelax() {
        return relax;
    }

    public void setRelax(Relax relax) {
        this.relax = relax;
    }
}
