package com.freetour.danang.dao.models;

import javax.persistence.*;

@Entity
@Table(name = "bookingtour")
public class BookingTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private Long id;

    @Column(name = "gmail")
    private String gmail;

    @Column(name = "name")
    private String name;

    @Column(name = "count_people")
    private int countPeople;

    @Column(name = "date_join")
    private String dateJoin;

    @Column(name = "time_tour")
    private String timeTour;

    @Column(name = "language")
    private String language;

    @Column(name = "yes_english")
    private String yesEnglish;

    @Column(name = "foody_story")
    private String foodyStory;

    @Column(name = "reason_notfoody")
    private String reasonNotfoody;

    @Column(name = "city")
    private String city;

    @Column(name = "how_know_us")
    private String howKnowUs;

    @Column(name = "contact")
    private String contact;

    @Column(name = "date_leave")
    private String dateLeave;

    @Column(name = "check_out")
    private String checkOut;

    @Column(name = "question")
    private String question;

    @Column(name = "other_email")
    private String otherEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    public String getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(String dateJoin) {
        this.dateJoin = dateJoin;
    }

    public String getTimeTour() {
        return timeTour;
    }

    public void setTimeTour(String timeTour) {
        this.timeTour = timeTour;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getYesEnglish() {
        return yesEnglish;
    }

    public void setYesEnglish(String yesEnglish) {
        this.yesEnglish = yesEnglish;
    }

    public String getFoodyStory() {
        return foodyStory;
    }

    public void setFoodyStory(String foodyStory) {
        this.foodyStory = foodyStory;
    }

    public String getReasonNotfoody() {
        return reasonNotfoody;
    }

    public void setReasonNotfoody(String reasonNotfoody) {
        this.reasonNotfoody = reasonNotfoody;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHowKnowUs() {
        return howKnowUs;
    }

    public void setHowKnowUs(String howKnowUs) {
        this.howKnowUs = howKnowUs;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDateLeave() {
        return dateLeave;
    }

    public void setDateLeave(String dateLeave) {
        this.dateLeave = dateLeave;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOtherEmail() {
        return otherEmail;
    }

    public void setOtherEmail(String otherEmail) {
        this.otherEmail = otherEmail;
    }
}
