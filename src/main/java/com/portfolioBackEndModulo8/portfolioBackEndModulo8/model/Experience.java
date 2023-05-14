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
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String experienceUrl;

    @Column(length = 1000)
    private String experienceImage;

    @NotNull
    private String experienceJobTitle;

    @NotNull
    private String experiencePeriod;

    @NotNull
    @Column(length = 1000)
    private String experienceActivity;
    
    @NotNull
    private String experienceInstitution;

    public Experience() {
    }

    public Experience(String experienceUrl, String experienceImage, String experienceJobTitle, String experiencePeriod, String experienceActivity, String experienceInstitution) {
        this.experienceUrl = experienceUrl;
        this.experienceImage = experienceImage;
        this.experienceJobTitle = experienceJobTitle;
        this.experiencePeriod = experiencePeriod;
        this.experienceActivity = experienceActivity;
        this.experienceInstitution = experienceInstitution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExperienceUrl() {
        return experienceUrl;
    }

    public void setExperienceUrl(String experienceUrl) {
        this.experienceUrl = experienceUrl;
    }

    public String getExperienceImage() {
        return experienceImage;
    }

    public void setExperienceImage(String experienceImage) {
        this.experienceImage = experienceImage;
    }

    public String getExperienceJobTitle() {
        return experienceJobTitle;
    }

    public void setExperienceJobTitle(String experienceJobTitle) {
        this.experienceJobTitle = experienceJobTitle;
    }

    public String getExperiencePeriod() {
        return experiencePeriod;
    }

    public void setExperiencePeriod(String experiencePeriod) {
        this.experiencePeriod = experiencePeriod;
    }

    public String getExperienceActivity() {
        return experienceActivity;
    }

    public void setExperienceActivity(String experienceActivity) {
        this.experienceActivity = experienceActivity;
    }

    public String getExperienceInstitution() {
        return experienceInstitution;
    }

    public void setExperienceInstitution(String experienceInstitution) {
        this.experienceInstitution = experienceInstitution;
    }

    
}
