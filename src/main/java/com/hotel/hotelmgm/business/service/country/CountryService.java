package com.hotel.hotelmgm.business.service.country;

import com.hotel.hotelmgm.business.model.Country;
import com.hotel.hotelmgm.business.service.AbstractService;
import com.hotel.hotelmgm.commons.Constants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CountryService extends AbstractService<Country> {
    public CountryService() {
        super(Country.class);
    }

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PU_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
