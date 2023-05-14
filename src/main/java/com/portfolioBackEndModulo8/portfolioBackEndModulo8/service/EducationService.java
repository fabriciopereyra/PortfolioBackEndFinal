/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.service;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Education;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.repository.IEducationRepository;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.IEducationService;
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
public class EducationService implements IEducationService {

    @Autowired
    IEducationRepository iEducationRepository;

    @Override
    public List<Education> getEducations() {
        return iEducationRepository.findAll();
    }

    @Override
    public Optional<Education> getEducation(Long id) {
        return iEducationRepository.findById(id);
    }

    @Override
    public void saveEducation(Education education) {
        iEducationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        iEducationRepository.deleteById(id);
    }

}
