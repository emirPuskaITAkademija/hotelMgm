package com.hotel.hotelmgm.business.service.privilege;

import com.hotel.hotelmgm.business.model.Privilege;
import com.hotel.hotelmgm.business.service.AbstractService;
import com.hotel.hotelmgm.commons.Constants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class PrivilegeService extends AbstractService<Privilege> implements PrivilegeServiceLocal {

    public PrivilegeService() {
        super(Privilege.class);
    }

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PU_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
