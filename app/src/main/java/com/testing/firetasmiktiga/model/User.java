package com.testing.firetasmiktiga.model;

public class User {

    private String id, nameSurname, email, pictureUrl, type, courseId;

    public User(String id, String nameSurname, String email, String pictureUrl, String type) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.type = type;
    }

    private User(){

    }

    public String getId() {
        return id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public String getEmail() {
        return email;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getType() {
        return type;
    }
}
