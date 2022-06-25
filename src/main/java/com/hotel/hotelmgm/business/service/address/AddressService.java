package com.hotel.hotelmgm.business.service.address;

import com.hotel.hotelmgm.business.model.Address;
import com.hotel.hotelmgm.business.service.AbstractService;
import com.hotel.hotelmgm.commons.Constants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddressService extends AbstractService<Address> {
    public AddressService() {
        super(Address.class);
    }

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PU_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
