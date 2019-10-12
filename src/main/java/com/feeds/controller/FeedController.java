package com.feeds.controller;

import com.feeds.entity.Feeds;
import com.feeds.entity.Items;
import com.feeds.helper.RSSParser;
import com.feeds.service.FeedService;
import com.feeds.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping
public class FeedController {

    // injecting services
    @Autowired
    private FeedService feedService;

    @Autowired
    private ItemService itemService;

    @RequestMapping
    public String listFeeds(ModelMap model) {
        // get feeds from the service
        List<Feeds> feeds = feedService.getFeeds();

        // add feeds to the model
        model.addAttribute("feeds", feeds);

        return "feeds-list";
    }

    @GetMapping("/addRSS")
    public String showFormForAddRSS(ModelMap model) {

        // create model attribute to get form data
        Feeds feeds = new Feeds();

        // add the feeds to the model
        model.addAttribute("feeds", feeds);

        return "feeds-add";
    }

    // All data for fields table is saved here
    @PostMapping("/saveFeed")
    public String saveFeed(@ModelAttribute("feeds") Feeds feeds, Items items) {
        // passing URL to rss parser
        RSSParser rssParser = new RSSParser(feeds.getUrl());

        feeds.setLastUpdate(rssParser.getLastUpdateDate());
        feeds.setTitleRSS(rssParser.getRssTitle());

        // save the RSS feed  using service
        feedService.saveToFeedsTable(feeds);

        // getting info about articles from the URL provided
        List<String> articlesTitles = rssParser.getArticles();
        List<String> articlesLinks = rssParser.getArticlesLinks();
        List<LocalDateTime> articlesDates = rssParser.getArticlesDates();

        // saving articles to the database
        for (int i = 0; i < articlesTitles.size() - 1; i++) {
            items.setFeedId(getLastEntryId()); // setting feed_id
            items.setTitleArticle(articlesTitles.get(i));
            items.setLink(articlesLinks.get(i));
            items.setPublished(articlesDates.get(i));
            itemService.saveItems(items);
        }

        return "redirect:/";
    }

    // a workaround to get the id of the last entry to the database
    // needed for cross-reference when saving data to items table
    private int getLastEntryId() {
        int last = feedService.getFeeds().size() - 1;
        return feedService.getFeeds().get(last).getId();
    }


    @RequestMapping("/details")
    public String showRSSDetails(@RequestParam("title") String title, ModelMap model) {
        // getting data from the database
        List<Feeds> feeds = feedService.getFeedsByTitle(title);
        int feedId = feeds.get(0).getId();
        List<Items> items = itemService.getItemsByFeedId(feedId);

        // add the feeds and items data to the model
        model.addAttribute("feeds", feeds.get(0));
        model.addAttribute("items", items);

        return "feeds-details";
    }

}
