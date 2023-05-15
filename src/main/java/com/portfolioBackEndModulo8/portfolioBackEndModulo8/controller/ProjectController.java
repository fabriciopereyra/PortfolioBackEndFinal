/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.controller;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.dto.ProjectDTO;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Project;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.controller.Message;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.IProjectService;
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
@RequestMapping("project")
public class ProjectController {

    @Autowired
    IProjectService iProjectService;

    @GetMapping("/getProject/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        if (iProjectService.getProject(id).isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(iProjectService.getProject(id), HttpStatus.OK);
    }

    @GetMapping("/getProjects")
    public ResponseEntity<List<Project>> getProjects() {
        return new ResponseEntity(iProjectService.getProjects(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveProject")
    public ResponseEntity<?> saveProject(@RequestBody ProjectDTO projectDto) {
        if (StringUtils.isBlank(projectDto.getProjectTitle())) {
            return new ResponseEntity(new Message("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(projectDto.getProjectPeriod())) {
            return new ResponseEntity(new Message("El periodo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(projectDto.getProjectDescription())) {
            return new ResponseEntity(new Message("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(projectDto.getProjectTechnology())) {
            return new ResponseEntity(new Message("La tecnologia es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Project project = new Project(projectDto.getProjectUrl(), projectDto.getProjectImage(), projectDto.getProjectTitle(), projectDto.getProjectDescription(), projectDto.getProjectPeriod(), projectDto.getProjectTechnology());
        iProjectService.saveProject(project);
        return new ResponseEntity(new Message("Proyecto agregado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateProject/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDto) {
        if (StringUtils.isBlank(projectDto.getProjectTitle())) {
            return new ResponseEntity(new Message("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(projectDto.getProjectPeriod())) {
            return new ResponseEntity(new Message("El periodo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(projectDto.getProjectDescription())) {
            return new ResponseEntity(new Message("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(projectDto.getProjectTechnology())) {
            return new ResponseEntity(new Message("La tecnologia es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Project project = iProjectService.getProject(id).get();
        project.setProjectUrl(projectDto.getProjectUrl());
        project.setProjectTitle(projectDto.getProjectTitle());
        project.setProjectPeriod(projectDto.getProjectPeriod());
        project.setProjectDescription(projectDto.getProjectDescription());
        project.setProjectTechnology(projectDto.getProjectTechnology());
        if (!StringUtils.isBlank(projectDto.getProjectImage())) {
            project.setProjectImage(projectDto.getProjectImage());
        }
        iProjectService.saveProject(project);
        return new ResponseEntity(new Message("Proyecto actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        if (iProjectService.getProject(id) == null) {
            return new ResponseEntity(new Message("Proyecto no existe"), HttpStatus.BAD_REQUEST);
        }
        iProjectService.deleteProject(id);
        return new ResponseEntity(new Message("Educacion eliminada"), HttpStatus.OK);
    }

}
