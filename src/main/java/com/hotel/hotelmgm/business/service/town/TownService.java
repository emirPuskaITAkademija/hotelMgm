package com.hotel.hotelmgm.business.service.town;

import com.hotel.hotelmgm.business.model.Town;
import com.hotel.hotelmgm.business.service.AbstractService;
import com.hotel.hotelmgm.commons.Constants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TownService extends AbstractService<Town> {
    public TownService() {
        super(Town.class);
    }

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PU_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
