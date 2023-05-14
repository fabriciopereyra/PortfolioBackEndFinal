/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Skill;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Fabricio
 */
public interface ISkillService {

    public List<Skill> getSkills();

    public Optional<Skill> getSkill(Long id);

    public void saveSkill(Skill skill);

    public void deleteSkill(Long id);
}
