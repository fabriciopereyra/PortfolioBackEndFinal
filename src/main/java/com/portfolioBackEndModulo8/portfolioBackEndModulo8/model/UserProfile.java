/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Fabricio
 */
@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userProfileName;

    @NotNull
    private String userProfileSurname;

    @Column(length = 1000)
    private String userProfileImage;

    @Column(length = 500)
    private String userProfileTitle;
    
    @Column(length = 1000)
    private String userProfileAbout;

    public UserProfile() {
    }

    public UserProfile(String userProfileName, String userProfileSurname, String userProfileImage, String userProfileTitle, String userProfileAbout) {
        this.userProfileName = userProfileName;
        this.userProfileSurname = userProfileSurname;
        this.userProfileImage = userProfileImage;
        this.userProfileTitle = userProfileTitle;
        this.userProfileAbout = userProfileAbout;
    }

    public String getUserProfileName() {
        return userProfileName;
    }

    public void setUserProfileName(String userProfileName) {
        this.userProfileName = userProfileName;
    }

    public String getUserProfileSurname() {
        return userProfileSurname;
    }

    public void setUserProfileSurname(String userProfileSurname) {
        this.userProfileSurname = userProfileSurname;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public String getUserProfileTitle() {
        return userProfileTitle;
    }

    public void setUserProfileTitle(String userProfileTitle) {
        this.userProfileTitle = userProfileTitle;
    }

    public String getUserProfileAbout() {
        return userProfileAbout;
    }

    public void setUserProfileAbout(String userProfileAbout) {
        this.userProfileAbout = userProfileAbout;
    }
    

    }
