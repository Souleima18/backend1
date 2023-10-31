package com.souleima.biscuits.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.souleima.biscuits.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
