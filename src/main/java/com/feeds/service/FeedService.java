package com.feeds.service;

import com.feeds.entity.Feeds;

import java.util.List;

public interface FeedService {

    List<Feeds> getFeeds();

    void saveToFeedsTable(Feeds feeds);

    List<Feeds> getFeedsByTitle(String title);
}
