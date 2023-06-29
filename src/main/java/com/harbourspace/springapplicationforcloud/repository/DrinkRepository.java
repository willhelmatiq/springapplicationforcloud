package com.harbourspace.springapplicationforcloud.repository;

import com.harbourspace.springapplicationforcloud.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {

    Drink findFirstByOrderByPriorityDesc();

    List<Drink> findTop3ByOrderByPriorityDesc();
}