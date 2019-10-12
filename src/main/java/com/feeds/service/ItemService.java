package com.feeds.service;

import com.feeds.entity.Items;

import java.util.List;

public interface ItemService {

    List<Items> getItems();

    void saveItems(Items items);

    List<Items> getItemsByFeedId(int id);
}
