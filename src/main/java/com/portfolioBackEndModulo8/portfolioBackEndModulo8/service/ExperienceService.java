/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.service;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Experience;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.repository.IExperienceRepository;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.IExperienceService;
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
public class ExperienceService implements IExperienceService {

    @Autowired
    IExperienceRepository iExperienceRepository;

    @Override
    public List<Experience> getExperiences() {
        return iExperienceRepository.findAll();
    }

    @Override
    public Optional<Experience> getExperience(Long id) {
        return iExperienceRepository.findById(id);
    }

    @Override
    public void saveExperience(Experience experience) {
        iExperienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        iExperienceRepository.deleteById(id);
    }

}
