package com.qunar.jbehave.basic;

/**
 * Created with IntelliJ IDEA. Author: xiappeng.cai Date: 14-11-23 Time: 下午4:32
 */
public class Student {
    private String name;
    private Integer age;
    private String hobby;
    private String fatherName;
    private String motherName;
    private String brotherName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getBrotherName() {
        return brotherName;
    }

    public void setBrotherName(String brotherName) {
        this.brotherName = brotherName;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", hobby='" + hobby + '\'' + ", fatherName='"
                + fatherName + '\'' + ", motherName='" + motherName + '\'' + ", brotherName='" + brotherName + '\''
                + '}';
    }
}
