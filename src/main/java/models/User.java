package models;

import java.util.ArrayList;
//st
public class User {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String gender;

    //to hold multiple user objects - arraylist
    private static ArrayList<User> userList = new ArrayList<>();

    //constructor
    public User(int id, String name, String surname, int age, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    //get/setter
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //getter for userlist
    public static ArrayList<User> getUserList() {
        return userList;
    }

    //added a user object to userlist
    public static void addUser(User user) {
        userList.add(user);
    }

    //overriding
    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                " }";
    }
}
