/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.controller;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.dto.UserProfileDTO;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.model.UserProfile;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.controller.Message;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.serviceInterface.IUserProfileService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fabricio
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "https://portfoliofrontendfinal.web.app/"})
@RequestMapping("userProfile")
public class UserProfileController {

    @Autowired
    IUserProfileService iUserProfileService;

    @GetMapping("/getUserProfile/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long id) {
        if (iUserProfileService.getUserProfile(id).isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(iUserProfileService.getUserProfile(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateUserProfile/{id}")
    public ResponseEntity<?> updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDto) {
        if (StringUtils.isBlank(userProfileDto.getUserProfileName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(userProfileDto.getUserProfileSurname())) {
            return new ResponseEntity(new Message("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        UserProfile userProfile = iUserProfileService.getUserProfile(id).get();
        userProfile.setUserProfileName(userProfileDto.getUserProfileName());
        userProfile.setUserProfileSurname(userProfileDto.getUserProfileSurname());
        userProfile.setUserProfileTitle(userProfileDto.getUserProfileTitle());
        userProfile.setUserProfileAbout(userProfileDto.getUserProfileAbout());
        if (!StringUtils.isBlank(userProfileDto.getUserProfileImage())) {
            userProfile.setUserProfileImage(userProfileDto.getUserProfileImage());
        }
        iUserProfileService.saveUserProfile(userProfile);
        return new ResponseEntity(new Message("Usuario actualizado"), HttpStatus.OK);
    }
//
//    @GetMapping("/getUserProfiles")
//    public ResponseEntity<List<UserProfile>> getUserProfiles() {
//        return new ResponseEntity(iUserProfileService.getUserProfiles(), HttpStatus.OK);
//    }
//    
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/saveUserProfile")
//    public ResponseEntity<?> saveUserProfile(@RequestBody UserProfileDTO userProfileDto) {
//        if (StringUtils.isBlank(userProfileDto.getUserProfileName())) {
//            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if (StringUtils.isBlank(userProfileDto.getUserProfileSurname())) {
//            return new ResponseEntity(new Message("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if (StringUtils.isBlank(userProfileDto.getUserProfileImage())) {
//            return new ResponseEntity(new Message("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
//        }
//        if (StringUtils.isBlank(userProfileDto.getUserProfileAbout())) {
//            return new ResponseEntity(new Message("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
//        }
//        UserProfile userProfile = new UserProfile(userProfileDto.getUserProfileName(), userProfileDto.getUserProfileSurname(), userProfileDto.getUserProfileImage(), userProfileDto.getUserProfileAbout());
//        iUserProfileService.saveUserProfile(userProfile);
//        return new ResponseEntity(new Message("Usuario agregado"), HttpStatus.OK);
//    }
//    
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/deleteUserProfile/{id}")
//    public ResponseEntity<?> deleteUserProfile(@PathVariable Long id) {
//        if (iUserProfileService.getUserProfile(id) == null) {
//            return new ResponseEntity(new Message("Usuario no existe"), HttpStatus.BAD_REQUEST);
//        }
//        iUserProfileService.deleteUserProfile(id);
//        return new ResponseEntity(new Message("Usuario eliminada"), HttpStatus.OK);
//    }
//
}
