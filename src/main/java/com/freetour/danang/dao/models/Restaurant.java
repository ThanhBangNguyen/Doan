package com.freetour.danang.dao.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "info")
    private String info;

    @Column(name = "dis_price_us")
    private String priceUS;

    @Column(name = "dis_price_vn")
    private String priceVN;

    @Column(name = "time_oc")
    private String timeOC;

    @Column(name = "link_map")
    private String linkMap;

    @Column(name = "short_info")
    private String shortInfo;

    @Column(name = "image")
    private String image;

    @Column(name = "video")
    private String video;

    @Column(name = "type")
    private Integer type;

    @Column(name = "banner")
    private String banner;


    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private Set<Menu> menus;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public String getTimeOC() {
        return timeOC;
    }

    public void setTimeOC(String timeOC) {
        this.timeOC = timeOC;
    }

    public String getLinkMap() {
        return linkMap;
    }

    public void setLinkMap(String linkMap) {
        this.linkMap = linkMap;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}
