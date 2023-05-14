/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.service;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Skill;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.repository.ISkillRepository;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.ISkillService;
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
public class SkillService implements ISkillService {

    @Autowired
    ISkillRepository iSkillRepository;

    @Override
    public List<Skill> getSkills() {
        return iSkillRepository.findAll();
    }

    @Override
    public Optional<Skill> getSkill(Long id) {
        return iSkillRepository.findById(id);
    }

    @Override
    public void saveSkill(Skill skill) {
        iSkillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        iSkillRepository.deleteById(id);
    }
}
