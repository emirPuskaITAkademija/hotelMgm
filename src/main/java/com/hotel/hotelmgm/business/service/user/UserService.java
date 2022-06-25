package com.hotel.hotelmgm.business.service.user;

import com.hotel.hotelmgm.business.model.User;
import com.hotel.hotelmgm.business.service.AbstractService;
import com.hotel.hotelmgm.commons.Constants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

class UserService extends AbstractService<User> implements UserServiceLocal{

    public UserService() {
        super(User.class);
    }

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PU_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    /**
     * Ova metoda će kao ulazne parametre uzeti username i plainPassword.
     * Kao izlaz će vratiti user objekat koji postoji u bazi u slučaju da je
     * korisnik ispravno unio username i plainPassword, a inače će vratiti null.
     *
     * @param username
     * @param plainPassword
     * @return user or null if user doesn't exist
     */
    public User login(String username, String plainPassword) {
        if (username == null || username.isEmpty() || plainPassword == null || plainPassword.isEmpty()) {
            return null;
        }
        //upit na bazu i vidimo da li postoji korisnik sa ovim username
        EntityManager entityManager = getEntityManager();
        //radimo upit po username
        Query query = entityManager.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        try {
            User user = (User) query.getSingleResult();
            //PLAIN password -> hashiranja  ?
            return plainPassword.equals(user.getPassword()) ? user : null;
        } catch (NonUniqueResultException | NoResultException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
