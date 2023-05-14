/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Experience;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Fabricio
 */
public interface IExperienceService {

    public List<Experience> getExperiences();

    public Optional<Experience> getExperience(Long id);

    public void saveExperience(Experience experience);

    public void deleteExperience(Long id);

}
