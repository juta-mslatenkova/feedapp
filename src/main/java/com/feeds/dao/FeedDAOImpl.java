package com.feeds.dao;

import com.feeds.entity.Feeds;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository - to register DAOimpl class
@Repository
public class FeedDAOImpl implements FeedDAO {

    // injecting the Session Factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Feeds> getFeeds() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Feeds> query = currentSession.createQuery("From Feeds", Feeds.class);

        // execute a query and return the result list
        return query.getResultList();
    }

    @Override
    public void saveFeed(Feeds feeds) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the feed
        currentSession.save(feeds);
    }

    @Override
    public List<Feeds> getFeedsByTitle(String title) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Feeds> query = currentSession.createQuery("From Feeds where feedName= :title");
        query.setParameter("title", title);

        // execute a query and return the result list
        return query.getResultList();
    }

}
