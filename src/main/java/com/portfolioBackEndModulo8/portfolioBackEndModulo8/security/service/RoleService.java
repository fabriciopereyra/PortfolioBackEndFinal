/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.service;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.model.Role;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.enums.RoleName;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.repository.IRoleRepository;

/**
 *
 * @author Fabricio
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    IRoleRepository iRoleRepository;

    public Optional<Role> getByRoleName(RoleName roleName) {
        return iRoleRepository.findByRoleName(roleName);
    }

    public void save(Role role) {
        iRoleRepository.save(role);
    }

}
