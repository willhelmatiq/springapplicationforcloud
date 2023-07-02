package com.harbourspace.springapplicationforcloud.repository;

import com.harbourspace.springapplicationforcloud.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

}
