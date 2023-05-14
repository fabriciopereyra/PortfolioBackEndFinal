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
public class EducationDTO {

    @NotBlank
    private String educationUrl;

    @NotBlank
    private String educationImage;

    @NotBlank
    private String educationTitle;

    @NotBlank
    private String educationPeriod;

    @NotBlank
    private String educationInstitution;

    public EducationDTO() {
    }

    public EducationDTO(String educationUrl, String educationImage, String educationTitle, String educationPeriod, String educationInstitution) {
        this.educationUrl = educationUrl;
        this.educationImage = educationImage;
        this.educationTitle = educationTitle;
        this.educationPeriod = educationPeriod;
        this.educationInstitution = educationInstitution;
    }

    public String getEducationUrl() {
        return educationUrl;
    }

    public void setEducationUrl(String educationUrl) {
        this.educationUrl = educationUrl;
    }

    public String getEducationImage() {
        return educationImage;
    }

    public void setEducationImage(String educationImage) {
        this.educationImage = educationImage;
    }

    public String getEducationTitle() {
        return educationTitle;
    }

    public void setEducationTitle(String educationTitle) {
        this.educationTitle = educationTitle;
    }

    public String getEducationPeriod() {
        return educationPeriod;
    }

    public void setEducationPeriod(String educationPeriod) {
        this.educationPeriod = educationPeriod;
    }

    public String getEducationInstitution() {
        return educationInstitution;
    }

    public void setEducationInstitition(String educationInstitution) {
        this.educationInstitution = educationInstitution;
    }

}
