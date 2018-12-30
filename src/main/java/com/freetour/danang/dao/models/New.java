package com.freetour.danang.dao.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "new")
public class New implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "new_id")
    private Long id;

    @Column(name = "new_title")
    private String newTitle;

    @Column(name = "short_infor")
    private String shortInfor;

    @Column(name = "infor")
    private String Infor;

    @Column(name = "link_image")
    private String linkImage;

    @Column(name = "source_author")
    private String sourceAuthor;

    @Column(name = "date")
    private String date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getShortInfor() {
        return shortInfor;
    }

    public void setShortInfor(String shortInfor) {
        this.shortInfor = shortInfor;
    }

    public String getInfor() {
        return Infor;
    }

    public void setInfor(String infor) {
        Infor = infor;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getSourceAuthor() {
        return sourceAuthor;
    }

    public void setSourceAuthor(String sourceAuthor) {
        this.sourceAuthor = sourceAuthor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
