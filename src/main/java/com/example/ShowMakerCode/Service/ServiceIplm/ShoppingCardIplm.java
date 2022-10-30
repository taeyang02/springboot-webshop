package com.example.ShowMakerCode.Service.ServiceIplm;

import com.example.ShowMakerCode.Entity.ShoppingCard;
import com.example.ShowMakerCode.Service.EntiryService.ShoppingCardService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
@SessionScope
public class ShoppingCardIplm implements ShoppingCardService {
    private Map<String, ShoppingCard> map = new HashMap<String,ShoppingCard>();
    public String idMap(ShoppingCard item){
        return item.getId()+item.getSize();
    }

    @Override
    public void add(ShoppingCard item){
        ShoppingCard addedItem = map.get(idMap(item));
        if (addedItem != null){
            addedItem.setQuantity(item.getQuantity() + addedItem.getQuantity());
        }else {
        map.put(idMap(item),item);}

    }
    @Override
    public void remove(String productID){
        map.remove(productID);
    }

    @Override
    public Collection<ShoppingCard> getCardItems() {
        return map.values();
    }

    @Override
    public void clear(){
        map.clear();
    }
    @Override
    public void update(String productIdMax, int Quantity){
        ShoppingCard item = map.get(productIdMax);
        item.setQuantity(Quantity);
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item ->  item.getQuantity()*item.getPrice().doubleValue()).sum();
    }

    @Override
    public int getCount(){
        if (map.isEmpty()){
            return 0;
        }
        return map.values().size();
    }

    @Override
    public Map<String, ShoppingCard> getMap(){
        return this.map;
    }


}
