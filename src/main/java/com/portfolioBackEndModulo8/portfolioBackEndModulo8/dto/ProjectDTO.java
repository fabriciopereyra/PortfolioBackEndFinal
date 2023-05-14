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
public class ProjectDTO {

    @NotBlank
    private String projectUrl;

    @NotBlank
    private String projectImage;

    @NotBlank
    private String projectTitle;

    @NotBlank
    private String projectDescription;

    @NotBlank
    private String projectPeriod;

    @NotBlank
    private String projectTechnology;

    public ProjectDTO() {
    }

    public ProjectDTO(String projectUrl, String projectImage, String projectTitle, String projectDescription, String projectPeriod, String projectTechnology) {
        this.projectUrl = projectUrl;
        this.projectImage = projectImage;
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.projectPeriod = projectPeriod;
        this.projectTechnology = projectTechnology;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(String projectPeriod) {
        this.projectPeriod = projectPeriod;
    }

    public String getProjectTechnology() {
        return projectTechnology;
    }

    public void setProjectTechnology(String projectTechnology) {
        this.projectTechnology = projectTechnology;
    }

}
