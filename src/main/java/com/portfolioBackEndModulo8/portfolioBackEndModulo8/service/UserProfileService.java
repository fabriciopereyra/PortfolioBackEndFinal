/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.service;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.UserProfile;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.repository.IUserProfileRepository;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.IUserProfileService;
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
public class UserProfileService implements IUserProfileService {

    @Autowired
    IUserProfileRepository iUserProfileRepository;

    @Override
    public List<UserProfile> getUserProfiles() {
        return iUserProfileRepository.findAll();
    }

    @Override
    public Optional<UserProfile> getUserProfile(Long id) {
        return iUserProfileRepository.findById(id);
    }

    @Override
    public void saveUserProfile(UserProfile userProfile) {
        iUserProfileRepository.save(userProfile);
    }

    @Override
    public void deleteUserProfile(Long id) {
        iUserProfileRepository.deleteById(id);
    }
}
