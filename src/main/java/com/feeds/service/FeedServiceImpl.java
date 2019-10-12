package com.feeds.service;

import com.feeds.dao.FeedDAO;
import com.feeds.entity.Feeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {

    // injecting Feed DAO
    @Autowired
    private FeedDAO feedDAO;

    @Override
    @Transactional
    public List<Feeds> getFeeds() {
        return feedDAO.getFeeds();
    }

    @Override
    @Transactional
    public void saveToFeedsTable(Feeds feeds) {
        feedDAO.saveFeed(feeds);
    }

    @Override
    @Transactional
    public List<Feeds> getFeedsByTitle(String title){
        return feedDAO.getFeedsByTitle(title);
    }

}
