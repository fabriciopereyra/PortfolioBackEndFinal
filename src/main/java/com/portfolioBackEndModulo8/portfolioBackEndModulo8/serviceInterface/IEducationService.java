/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.Education;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Fabricio
 */
public interface IEducationService {

    public List<Education> getEducations();

    public Optional<Education> getEducation(Long id);

    public void saveEducation(Education education);

    public void deleteEducation(Long id);
}
