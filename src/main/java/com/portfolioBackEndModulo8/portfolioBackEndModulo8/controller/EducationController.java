/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.controller;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.dto.EducationDTO;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Education;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.controller.Message;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.IEducationService;
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
@RequestMapping("education")
public class EducationController {

    @Autowired
    IEducationService iEducationService;

    @GetMapping("/getEducation/{id}")
    public ResponseEntity<Education> getEducation(@PathVariable Long id) {
        if (iEducationService.getEducation(id).isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(iEducationService.getEducation(id), HttpStatus.OK);
    }

    @GetMapping("/getEducations")
    public ResponseEntity<List<Education>> getEducations() {
        return new ResponseEntity(iEducationService.getEducations(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveEducation")
    public ResponseEntity<?> saveEducation(@RequestBody EducationDTO educationDto) {
        if (StringUtils.isBlank(educationDto.getEducationInstitution())) {
            return new ResponseEntity(new Message("La institucion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educationDto.getEducationTitle())) {
            return new ResponseEntity(new Message("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educationDto.getEducationPeriod())) {
            return new ResponseEntity(new Message("El periodo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Education education = new Education(educationDto.getEducationUrl(), educationDto.getEducationImage(), educationDto.getEducationTitle(), educationDto.getEducationPeriod(), educationDto.getEducationInstitution());
        iEducationService.saveEducation(education);
        return new ResponseEntity(new Message("Educacion agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateEducation/{id}")
    public ResponseEntity<?> updateEducation(@PathVariable Long id, @RequestBody EducationDTO educationDto) {
        if (StringUtils.isBlank(educationDto.getEducationInstitution())) {
            return new ResponseEntity(new Message("La institucion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educationDto.getEducationTitle())) {
            return new ResponseEntity(new Message("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educationDto.getEducationPeriod())) {
            return new ResponseEntity(new Message("El periodo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Education education = iEducationService.getEducation(id).get();
        education.setEducationUrl(educationDto.getEducationUrl());
        education.setEducationTitle(educationDto.getEducationTitle());
        education.setEducationPeriod(educationDto.getEducationPeriod());
        education.setEducationInstitution(educationDto.getEducationInstitution());
        if (!StringUtils.isBlank(educationDto.getEducationImage())) {
            education.setEducationImage(educationDto.getEducationImage());
        }
        iEducationService.saveEducation(education);
        return new ResponseEntity(new Message("Educacion actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteEducation/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable Long id) {
        if (iEducationService.getEducation(id) == null) {
            return new ResponseEntity(new Message("Educacion no existe"), HttpStatus.BAD_REQUEST);
        }
        iEducationService.deleteEducation(id);
        return new ResponseEntity(new Message("Educacion eliminada"), HttpStatus.OK);
    }

}
