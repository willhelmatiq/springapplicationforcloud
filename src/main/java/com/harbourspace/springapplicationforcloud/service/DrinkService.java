package com.harbourspace.springapplicationforcloud.service;

import com.harbourspace.springapplicationforcloud.entity.Drink;
import com.harbourspace.springapplicationforcloud.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    public void addDrink(Drink drink) {
        drinkRepository.save(drink);
    }

    public Drink getFavouriteDrink() {
       return drinkRepository.findFirstByOrderByPriorityDesc();
    }

    public List<Drink> getFavouriteDrinkLeaderboard() {
        return drinkRepository.findTop3ByOrderByPriorityDesc();
    }
}
