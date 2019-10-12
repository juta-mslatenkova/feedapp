package com.feeds.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String titleArticle;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private LocalDateTime published;

    @Column(name = "feed_id")
    private int feedId;

    public void setFeedId (int feedId){
        this.feedId = feedId;
    }

    public String getTitleArticle() {
        return titleArticle;
    }

    public void setTitleArticle(String titleArticle) {
        this.titleArticle = titleArticle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }
}
