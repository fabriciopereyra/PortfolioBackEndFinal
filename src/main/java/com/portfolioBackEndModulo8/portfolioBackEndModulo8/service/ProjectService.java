/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.service;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Project;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.repository.IProjectRepository;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.IProjectService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fabricio
 */
@Service
@Transactional
public class ProjectService implements IProjectService {

    @Autowired
    IProjectRepository iProjectRepository;

    @Override
    public List<Project> getProjects() {
        return iProjectRepository.findAll();
    }

    @Override
    public Optional<Project> getProject(Long id) {
        return iProjectRepository.findById(id);
    }

    @Override
    public void saveProject(Project project) {
        iProjectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        iProjectRepository.deleteById(id);
    }
}
