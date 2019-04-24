package com.freetour.danang.dao.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "relax")
public class Relax implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relax")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "infor")
    private String infor;
    @Column(name = "price_us")
    private String priceUS;

    @Column(name = "price_vn")
    private String priceVN;

    @Column(name = "address")
    private String address;
    @Column(name = "image")
    private String image;

    @Column(name = "phone")
    private String phone;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryRL;

    @OneToMany(mappedBy = "relax", fetch = FetchType.EAGER)
    private Set<MenuRelax> menuRelaxes;

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

    public String getPriceUS() {
        return priceUS;
    }

    public void setPriceUS(String priceUS) {
        this.priceUS = priceUS;
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

    public String getPriceVN() {
        return priceVN;
    }

    public void setPriceVN(String priceVN) {
        this.priceVN = priceVN;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Category getCategoryRL() {
        return categoryRL;
    }

    public void setCategoryRL(Category categoryRL) {
        this.categoryRL = categoryRL;
    }

    public Set<MenuRelax> getMenuRelaxes() {
        return menuRelaxes;
    }

    public void setMenuRelaxes(Set<MenuRelax> menuRelaxes) {
        this.menuRelaxes = menuRelaxes;
    }
}
