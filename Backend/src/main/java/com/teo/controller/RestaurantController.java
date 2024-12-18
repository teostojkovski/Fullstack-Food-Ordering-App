package com.teo.controller;

import com.teo.dto.RestaurantDto;
import com.teo.model.Restaurant;
import com.teo.model.User;
import com.teo.request.CreateRestaurantRequest;
import com.teo.service.RestaurantService;
import com.teo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(@RequestHeader("Authorization") String jwt,
                                                 @RequestParam String keyword) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant = restaurantService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestHeader("Authorization") String jwt) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant>findRestaurantById(@RequestHeader("Authorization") String jwt,
                                                               @PathVariable Long id) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurantService.findById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto>addToFavorites(@RequestHeader("Authorization") String jwt,
                                                        @PathVariable Long id) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        RestaurantDto restaurant = restaurantService.addToFavourites(id, user);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
