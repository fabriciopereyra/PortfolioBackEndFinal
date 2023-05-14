/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Fabricio
 */
public class ExperienceDTO {

    @NotBlank
    private String experienceUrl;

    @NotBlank
    private String experienceImage;

    @NotBlank
    private String experienceJobTitle;

    @NotBlank
    private String experiencePeriod;

    @NotBlank
    private String experienceActivity;
    
    @NotBlank
    private String experienceInstitution;

    public ExperienceDTO() {
    }

    public ExperienceDTO(String experienceUrl, String experienceImage, String experienceJobTitle, String experiencePeriod, String experienceActivity, String experienceInstitution) {
        this.experienceUrl = experienceUrl;
        this.experienceImage = experienceImage;
        this.experienceJobTitle = experienceJobTitle;
        this.experiencePeriod = experiencePeriod;
        this.experienceActivity = experienceActivity;
        this.experienceInstitution = experienceInstitution;
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
