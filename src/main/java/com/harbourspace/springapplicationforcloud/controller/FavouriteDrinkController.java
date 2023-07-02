package com.harbourspace.springapplicationforcloud.controller;

import com.harbourspace.springapplicationforcloud.entity.Drink;
import com.harbourspace.springapplicationforcloud.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/coffee/favourite")
public class FavouriteDrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping()
    public Drink getFavouriteDrink() {
        return drinkService.getFavouriteDrink();
    }

    @GetMapping("/leaderboard")
    public List<Drink> getFavouriteDrinkLeaderboard() {
        return drinkService.getFavouriteDrinkLeaderboard();
    }

    @PostMapping()
    public ResponseEntity<String> addFavouriteDrink(@RequestBody Drink drink) {
        drinkService.addDrink(drink);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
