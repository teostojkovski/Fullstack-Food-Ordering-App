package com.teo.service;

import com.teo.model.Category;
import com.teo.model.Food;
import com.teo.model.Restaurant;
import com.teo.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long id) throws Exception;

    public List<Food> getAllFood(Long restaurantId,
                                 boolean isVegetarian,
                                 boolean isNonVegetarian,
                                 boolean isSeasonal,
                                 String foodCategory
    );

    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long id) throws Exception;
    public Food updateAvailabilityStatus(Long id) throws Exception;
}
