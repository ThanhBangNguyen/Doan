package com.freetour.danang.dto;

import javax.persistence.Column;

public class NewDTO {
    private Long id;
    private String newTitle;
    private String shortInfor;
    private String Infor;
    private String linkImage;
    private String sourceAuthor;
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
