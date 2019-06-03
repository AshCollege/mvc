package com.dev;

import com.dev.Objects.Entities.Product;
import com.dev.Objects.General.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.dev.Utils.Definitions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sigal on 5/20/2016.
 */
@Transactional
@Component
@SuppressWarnings("unchecked")
public class Persist {

    private static final Logger LOGGER = LoggerFactory.getLogger(Persist.class);

    private SessionFactory sessionFactory;

    @Autowired
    public Persist(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public Session getQuerySession() {
        return sessionFactory.getCurrentSession();
    }

    public List<String> getDbClasses () {
        return new ArrayList<>(sessionFactory.getAllClassMetadata().keySet());
    }

    public void saveAll(List<? extends BaseEntity> objects) {
        for (BaseEntity object : objects) {
            save(object);
        }
    }

    public void save(Object o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    public <T> T loadObject(Class<T> clazz, int oid) {
        return (T) getQuerySession().get(clazz, oid);
    }

    public <T> List<T> getList(Class<T> clazz) {
        return (List<T>) getQuerySession().createQuery(String.format("FROM %s WHERE deleted=FALSE", clazz.getSimpleName())).list();
    }

    public Object load(Class clazz, long id) {
        return getQuerySession().get(clazz, id);
    }

    public <T> List<T> loadList(Class<T> clazz) {
        return getQuerySession().createCriteria(clazz).list();
    }

    public <T> void delete(Class<T> clazz) {
        getQuerySession().createQuery(String.format("DELETE FROM %s", clazz.getSimpleName())).executeUpdate();
    }

    public <T> void delete(Class<T> clazz, int oid) {
        getQuerySession().createQuery(String.format("DELETE FROM %s WHERE oid=%s", clazz.getSimpleName(), oid)).executeUpdate();
    }

    public <T> void delete(Class<T> clazz, List<Integer> oidsList) {
        getQuerySession().createQuery(String.format("DELETE FROM %s WHERE oid IN (:oidsList)", clazz.getSimpleName())).setParameterList(PARAM_OIDS_LIST, oidsList).executeUpdate();
    }

    public List<Product> loadProductBySeller(int sellerOid) {
        return getQuerySession().createQuery("FROM Product p WHERE p.seller.oid = " + sellerOid).list();
    }


}