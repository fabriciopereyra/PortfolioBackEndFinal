/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.controller;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.dto.ExperienceDTO;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Experience;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.controller.Message;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.IExperienceService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fabricio
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "https://portfoliofrontendfinal.web.app/"})
@RequestMapping("experience")
public class ExperienceController {

    @Autowired
    IExperienceService iExperienceService;

    @GetMapping("/getExperience/{id}")
    public ResponseEntity<Experience> getExperience(@PathVariable Long id) {
        if (iExperienceService.getExperience(id).isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(iExperienceService.getExperience(id), HttpStatus.OK);
    }

    @GetMapping("/getExperiences")
    public ResponseEntity<List<Experience>> getExperiences() {
        return new ResponseEntity(iExperienceService.getExperiences(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveExperience")
    public ResponseEntity<?> saveExperience(@RequestBody ExperienceDTO experienceDto) {
        if (StringUtils.isBlank(experienceDto.getExperienceJobTitle())) {
            return new ResponseEntity(new Message("El puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienceDto.getExperiencePeriod())) {
            return new ResponseEntity(new Message("El periodo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienceDto.getExperienceActivity())) {
            return new ResponseEntity(new Message("La actividad es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Experience experience = new Experience(experienceDto.getExperienceUrl(), experienceDto.getExperienceImage(), experienceDto.getExperienceJobTitle(), experienceDto.getExperiencePeriod(), experienceDto.getExperienceActivity(), experienceDto.getExperienceInstitution());
        iExperienceService.saveExperience(experience);
        return new ResponseEntity(new Message("Experiencia agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateExperience/{id}")
    public ResponseEntity<?> updateExperince(@PathVariable Long id, @RequestBody ExperienceDTO experienceDto) {
        if (StringUtils.isBlank(experienceDto.getExperienceJobTitle())) {
            return new ResponseEntity(new Message("El puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienceDto.getExperiencePeriod())) {
            return new ResponseEntity(new Message("El periodo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienceDto.getExperienceActivity())) {
            return new ResponseEntity(new Message("La actividad es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Experience experience = iExperienceService.getExperience(id).get();
        experience.setExperienceUrl(experienceDto.getExperienceUrl());
        experience.setExperienceJobTitle(experienceDto.getExperienceJobTitle());
        experience.setExperiencePeriod(experienceDto.getExperiencePeriod());
        experience.setExperienceActivity(experienceDto.getExperienceActivity());
        experience.setExperienceInstitution(experienceDto.getExperienceInstitution());
        if (!StringUtils.isBlank(experienceDto.getExperienceImage())) {
            experience.setExperienceImage(experienceDto.getExperienceImage());
        }
        iExperienceService.saveExperience(experience);
        return new ResponseEntity(new Message("Experiencia actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteExperience/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable Long id) {
        if (iExperienceService.getExperience(id) == null) {
            return new ResponseEntity(new Message("Experiencia no existe"), HttpStatus.BAD_REQUEST);
        }
        iExperienceService.deleteExperience(id);
        return new ResponseEntity(new Message("Experiencia eliminada"), HttpStatus.OK);
    }

}
