package com.feeds.dao;

import com.feeds.entity.Items;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemsDAOImpl implements ItemsDAO {

    // injecting the Session Factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Items> getItems(){

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Items> query = currentSession.createQuery("From Items", Items.class);

        // execute a query and return the result list
        return query.getResultList();
    }

    @Override
    public void saveItems(Items items) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the items
        currentSession.save(items);
    }

    @Override
    public List<Items> getItemsByFeedId(int id) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Items> query = currentSession.createQuery("From Items where feedId= :id");
        query.setParameter("id", id);

        // execute a query and return the result list
        return query.getResultList();
    }
}
