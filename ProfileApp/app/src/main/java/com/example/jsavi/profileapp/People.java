package com.example.jsavi.profileapp;

import android.os.Parcelable;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class People implements Parcelable {

    private String userName;
    private  String userAbout;
    private String userEmail;
    private int userRepos;
    private  int userProjects;
    private  int userStars;


    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAbout(){
        return userAbout;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserRepos(){
        return userRepos;
    }

    public void setUserProjects(int userProjects) {
        this.userProjects = userProjects;
    }

    public int getUserProjects(){
        return userProjects;
    }

    public void setUserRepos(int userRepos) {
        this.userRepos = userRepos;
    }

    public int getUserStars() {
        return userStars;
    }

    public void setUserStars(int userStars) {
        this.userStars = userStars;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destiny, int flags){
        destiny.writeString(this.userName);
        destiny.writeString(this.userAbout);
        destiny.writeString(this.userEmail);
        destiny.writeInt(this.userProjects);
        destiny.writeInt(this.userRepos);
        destiny.writeInt(this.userStars);
    }

    public People(){

    }
    protected People(Parcel in){
        this.userName=in.readString();
        this.userAbout=in.readString();
        this.userEmail=in.readString();
        this.userRepos=in.readInt();
        this.userProjects=in.readInt();
        this.userStars=in.readInt();
    }

    public static final Creator<People>CREATOR=new Creator<People>() {
        @Override
        public People createFromParcel(Parcel source) {
            return new People(source);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

}
