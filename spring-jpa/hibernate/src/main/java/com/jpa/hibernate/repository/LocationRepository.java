package com.jpa.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.hibernate.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
