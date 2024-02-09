package models;

public class User {
    private int id;
    private String name;
    private String surname;
    private int age;
    private boolean gender;

    //constructor
    public User(int id, String name, String surname, int age, boolean gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
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

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    //overriding
    @Override
    public String toString() {
        return getId() + ": " +
                getName() + " " +
                getSurname() + " " +
                getAge() + " " +
                (getGender() ? "male" : "female");
    }
}
