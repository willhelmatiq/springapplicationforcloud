package com.harbourspace.springapplicationforcloud.controller;

import com.harbourspace.springapplicationforcloud.model.Drink;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/coffee/favourite")
public class FavouriteDrinkController {

    static final String AuthorizationHeader = "my_header";
    static final List<Drink> drinks = new ArrayList<>();
    static final Set<Drink> drinkSet = new HashSet<>();

    static {
        Drink favouriteDrink = new Drink("espresso");
        drinks.add(favouriteDrink);
        drinkSet.add(favouriteDrink);
    }


    @GetMapping()
    public Drink getFavouriteDrink(@RequestHeader(name = "Authorization") String headerParam) {
        if (!headerParam.equals(AuthorizationHeader)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return drinks.get(0);
    }

    @GetMapping("/leaderboard")
    public List<Drink> getFavouriteDrinkLeaderboard(@RequestHeader(name = "Authorization") String headerParam) {
        if (!headerParam.equals(AuthorizationHeader)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return drinks.stream().limit(3).collect(Collectors.toList());
    }

    @PostMapping
    public Drink addFavouriteDrink(@RequestHeader(name = "Authorization") String headerParam, @RequestBody Drink drink) {
        if (!headerParam.equals(AuthorizationHeader)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        if (!drinkSet.contains(drink)) {
            drinks.add(drink);
            drinkSet.add(drink);
            return drink;
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }


}
