package com.ourowproject.owproject.dtos;

public class Opponent {
    public int id;
    public String name;
    public String acronym;
    public String image_url;

    public Opponent(int id, String name, String acronym, String image_url) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
