package com.feeds.service;

import com.feeds.dao.ItemsDAO;
import com.feeds.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    // injecting Feed DaAO
    @Autowired
    private ItemsDAO itemsDAO;

    @Override
    @Transactional
    public List<Items> getItems() {
        return itemsDAO.getItems();
    }

    @Override
    @Transactional
    public void saveItems(Items items) {
        itemsDAO.saveItems(items);
    }

    @Override
    @Transactional
    public List<Items> getItemsByFeedId(int id) {
        return itemsDAO.getItemsByFeedId(id);
    }
}
