package com.feeds.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feeds")
public class Feeds {

    @Id
    @Column (name="id")
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String titleRSS;

    @Column(name = "last_update", columnDefinition = "DATETIME")
    private LocalDateTime lastUpdate;

    @Column(name = "feed_name")
    private String feedName;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitleRSS() {
        return titleRSS;
    }

    public void setTitleRSS(String titleRSS) {
        this.titleRSS = titleRSS;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

}
