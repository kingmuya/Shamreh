package com.example.firebaseapp2020;

public class User {
    private String names,email,age,id;

    public User(String names, String email, String age, String id) {
        this.names = names;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    public User() {
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
