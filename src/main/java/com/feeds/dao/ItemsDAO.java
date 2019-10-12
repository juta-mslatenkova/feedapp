package com.feeds.dao;

import com.feeds.entity.Items;

import java.util.List;

public interface ItemsDAO {

    List<Items> getItems();

    void saveItems(Items items);

    List<Items> getItemsByFeedId(int id);
}
