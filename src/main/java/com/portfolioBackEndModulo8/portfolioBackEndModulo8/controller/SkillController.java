/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.controller;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.dto.SkillDTO;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Skill;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.controller.Message;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.ISkillService;
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
@RequestMapping("skill")
public class SkillController {

    @Autowired
    ISkillService iSkillService;

    @GetMapping("/getSkill/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable Long id) {
        if (iSkillService.getSkill(id).isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(iSkillService.getSkill(id), HttpStatus.OK);
    }

    @GetMapping("/getSkills")
    public ResponseEntity<List<Skill>> getSkills() {
        return new ResponseEntity(iSkillService.getSkills(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveSkill")
    public ResponseEntity<?> savaSkill(@RequestBody SkillDTO skillDto) {
        if (StringUtils.isBlank(skillDto.getSkillName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillDto.getSkillProgress() == 0) {
            return new ResponseEntity(new Message("El progreso es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(skillDto.getSkillName(), skillDto.getSkillProgress());
        iSkillService.saveSkill(skill);
        return new ResponseEntity(new Message("Habilidad agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateSkill/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id, @RequestBody SkillDTO skillDto) {
        if (StringUtils.isBlank(skillDto.getSkillName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(String.valueOf(skillDto.getSkillProgress()))) {
            return new ResponseEntity(new Message("El progreso es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = iSkillService.getSkill(id).get();
        skill.setSkillName(skillDto.getSkillName());
        skill.setSkillProgress(skillDto.getSkillProgress());
        iSkillService.saveSkill(skill);
        return new ResponseEntity(new Message("Habilidad actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteSkill/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long id
    ) {
        if (iSkillService.getSkill(id) == null) {
            return new ResponseEntity(new Message("Habilidad no existe"), HttpStatus.BAD_REQUEST);
        }
        iSkillService.deleteSkill(id);
        return new ResponseEntity(new Message("Habilidad eliminada"), HttpStatus.OK);
    }

}
