/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.repository;

import com.portfolioBackEndModulo8.portfolioBackEndModulo8.security.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fabricio
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByUserName(String userName);

    public boolean existsByUserName(String userName);

    public boolean existsByEmail(String email);

}
