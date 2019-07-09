package com.learn.springdemo.model;

public class HomeModel {

    private String homeName;
    private int totalMembers;

    public HomeModel(){}

    public HomeModel(String homeName, int totalMembers){
        this.homeName = homeName;
        this.totalMembers = totalMembers;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    @Override
    public String toString() {
        return "HomeModel{" +
                "homeName='" + homeName + '\'' +
                ", totalMembers=" + totalMembers +
                '}';
    }
}
