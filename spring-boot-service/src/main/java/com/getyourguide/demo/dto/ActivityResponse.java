package com.getyourguide.demo.dto;

import com.getyourguide.demo.entity.Activity;

public record ActivityResponse(String title, Double price, String currency, Double rating, Boolean specialOffer,
                               String supplierName, String supplierLocation) {

    public static ActivityResponse toActivityResponse(Activity activity) {
        return new ActivityResponse(activity.getTitle(), activity.getPrice(), activity.getCurrency(), activity.getRating(), activity.getSpecialOffer(), activity.getSupplier().getName(), activity.getSupplier().getAddress() + ", " + activity.getSupplier().getCity() + ", " + activity.getSupplier().getCountry());
    }

}
