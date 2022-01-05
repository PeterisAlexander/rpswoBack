package com.game.rpswoBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.rpswoBack.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	public UserEntity findByUsername(String username);
}
