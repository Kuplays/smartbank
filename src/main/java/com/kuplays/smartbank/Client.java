package com.kuplays.smartbank;

public class Client {
    private long id;
    private short age;
    private String name;

    public Client() { }
    public Client(short age, String nameDetails) {
        this.age = age;
        this.name = nameDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameDetails) {
        this.name = nameDetails;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", age=" + age +
                ", nameDetails='" + name + '\'' +
                '}';
    }
}
