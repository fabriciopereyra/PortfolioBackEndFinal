/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Project;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Fabricio
 */
public interface IProjectService {

    public List<Project> getProjects();

    public Optional<Project> getProject(Long id);

    public void saveProject(Project project);

    public void deleteProject(Long id);
}
