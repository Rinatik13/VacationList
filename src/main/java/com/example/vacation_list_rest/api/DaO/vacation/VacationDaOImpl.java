package com.example.vacation_list_rest.api.DaO.vacation;

import com.example.vacation_list_rest.api.entity.Employee;
import com.example.vacation_list_rest.api.entity.Vacation;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VacationDaOImpl implements VacationDaO{
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Vacation> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Vacation> vacationQuery = session.createQuery("from Vacation",
                Vacation.class);
        return vacationQuery.getResultList();
    }

    @Override
    public Vacation addVacation(Vacation vacation) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(vacation);
        return vacation;
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Vacation vacation = session.get(Vacation.class,id);
        session.delete(vacation);
    }

    @Override
    public Vacation getVacation(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Vacation.class,id);

    }

    @Override
    public Vacation editVacation(Vacation vacation) {
        Session session = entityManager.unwrap(Session.class);
        Vacation vacation1 = session.get(Vacation.class, vacation.getId());
        vacation1.setType(vacation.getType());
        vacation1.setDateFrom(vacation.getDateFrom());
        vacation1.setDateTo(vacation.getDateTo());
        session.saveOrUpdate(vacation1);
        return vacation1;
    }
}
