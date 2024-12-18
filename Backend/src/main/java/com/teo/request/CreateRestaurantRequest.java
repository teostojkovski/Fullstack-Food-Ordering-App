package com.teo.request;

import com.teo.model.Address;
import com.teo.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {

    private Long id;
    private String name;
    private String description;
    private String cuisine;
    private Address address;
    private ContactInformation contactInformation;
    private String openingHours;
    private List<String> images;
}
