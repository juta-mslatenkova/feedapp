package com.feeds.dao;

import com.feeds.entity.Feeds;

import java.util.List;

public interface FeedDAO {

    List<Feeds> getFeeds();

    void saveFeed(Feeds feeds);

    List<Feeds> getFeedsByTitle(String title);

}
