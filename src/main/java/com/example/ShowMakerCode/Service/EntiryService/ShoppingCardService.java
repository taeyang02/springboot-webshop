package com.example.ShowMakerCode.Service.EntiryService;


import com.example.ShowMakerCode.Entity.Product;
import com.example.ShowMakerCode.Entity.ShoppingCard;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public interface ShoppingCardService {


    void add(ShoppingCard item);


    void remove(String productID);

    Collection<ShoppingCard> getCardItems();

    void clear();


    void update(String productIdMax, int Quantity);

     double getAmount();

    int getCount();

    Map<String, ShoppingCard> getMap();
}
