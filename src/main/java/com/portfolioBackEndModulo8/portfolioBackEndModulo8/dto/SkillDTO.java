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
public class SkillDTO {

    @NotBlank
    private String skillName;

    @NotBlank
    private int skillProgress;

    public SkillDTO() {
    }

    public SkillDTO(String skillName, int skillProgress) {
        this.skillName = skillName;
        this.skillProgress = skillProgress;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillProgress() {
        return skillProgress;
    }

    public void setSkillProgress(int skillProgress) {
        this.skillProgress = skillProgress;
    }
    
}
