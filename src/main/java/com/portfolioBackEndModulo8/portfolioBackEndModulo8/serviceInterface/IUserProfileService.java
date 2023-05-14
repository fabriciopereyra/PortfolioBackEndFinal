/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.UserProfile;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Fabricio
 */
public interface IUserProfileService {

    public List<UserProfile> getUserProfiles();

    public Optional<UserProfile> getUserProfile(Long id);

    public void saveUserProfile(UserProfile userProfile);

    public void deleteUserProfile(Long id);
}
