package com.feeds.helper;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RSSParser {
    private static SyndFeed feeder;
    private static SyndEntry syndEntry;

    public RSSParser(String rssUrl) {
        XmlReader xmlReader = null;

        try {
            xmlReader = new XmlReader(new URL(rssUrl));
            feeder = new SyndFeedInput().build(xmlReader);
        } catch (FeedException | IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                try {
                    xmlReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // get rss page title
    public String getRssTitle() {
        System.out.println("Title " + feeder.getAuthor());
        return feeder.getAuthor();
    }

    // get the date of the last published article
    public LocalDateTime getLastUpdateDate() {
        LocalDateTime dateTime = convertToLocalDateTimeViaMilisecond(feeder.getEntries().get(0).getPublishedDate());
        System.out.println(dateTime);
        return dateTime;
    }

    // convert from date to localDateTime
    private LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }


    // get the list of all articles of the rss feed
    public List<String> getArticles() {
        List<String> articlesList = new ArrayList<>();
        for (SyndEntry syndEntry1 : feeder.getEntries()) {
            syndEntry = syndEntry1;
            articlesList.add(syndEntry.getTitle());
        }

        return articlesList;

    }

    // get link to  each article
    public List<String> getArticlesLinks() {
        List<String> articlesLinksList = new ArrayList<>();
        for (SyndEntry syndEntry1 : feeder.getEntries()) {
            syndEntry = syndEntry1;
            articlesLinksList.add(syndEntry.getLink());
            System.out.println(syndEntry.getLink());
        }
        return articlesLinksList;
    }

    // get the dates when articles were published
    public List<LocalDateTime> getArticlesDates() {
        List<LocalDateTime> articlesDate = new ArrayList<>();
        for (SyndEntry syndEntry1 : feeder.getEntries()) {
            syndEntry = syndEntry1;

            articlesDate.add(convertToLocalDateTimeViaMilisecond(syndEntry.getPublishedDate()));
            System.out.println(syndEntry.getLink());
        }
        return articlesDate;
    }
}