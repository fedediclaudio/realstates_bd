package com.dbd.realstate.repositories;

import com.dbd.realstate.RealStateExcepction;
import com.dbd.realstate.model.Employee;
import com.dbd.realstate.model.RealState;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealStateRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Long saveRealState(RealState realState) throws RealStateExcepction {
        Session session = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            return (Long) session.save(realState);
        } catch (Exception e) {
            throw new RealStateExcepction(e.getMessage());
        }
    }

    public RealState findRealStateById(Long id) throws RealStateExcepction {
        try {
            return (RealState) this.sessionFactory.getCurrentSession().createQuery("from RealState where id = :id").setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            throw new RealStateExcepction(e.getMessage());
        }
    }

    public void updateRealState(RealState realState) throws RealStateExcepction {
        Session session = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            session.save(realState);
        } catch (Exception e) {
            throw new RealStateExcepction(e.getMessage());
        }
    }

    public Long createEmployee(Employee employee) throws RealStateExcepction {
        Session session = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            return (Long) session.save(employee);
        } catch (Exception e) {
            throw new RealStateExcepction(e.getMessage());
        }
    }

    public Employee getEmployeeById(Long id) throws RealStateExcepction {
        try {
            return (Employee) this.sessionFactory.getCurrentSession().createQuery("from Employee where id = :id").setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            throw new RealStateExcepction(e.getMessage());
        }
    }

    public Employee getEmployeeByDni(String dni) throws RealStateExcepction {
        try {
            return (Employee) this.sessionFactory.getCurrentSession().createQuery("from Employee where dni = :dni").setParameter("dni", dni).uniqueResult();
        } catch (Exception e) {
            throw new RealStateExcepction(e.getMessage());
        }
    }

    public RealState getRealStateById(Long id) throws RealStateExcepction {
        try {
            return (RealState) this.sessionFactory.getCurrentSession().createQuery("from RealState where id = :id").setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            throw new RealStateExcepction(e.getMessage());
        }
    }

    public boolean deleteEmployee(Employee employee) throws RealStateExcepction{
        Session session = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            session.remove(employee);
            return true;
        } catch (Exception e) {
            throw new RealStateExcepction(e.getMessage());
        }
    }

    public List<Employee> employeesWithCalificationGreatherThan(float calification) throws RealStateExcepction {
        try {
            return (List<Employee>) this.sessionFactory.getCurrentSession().createQuery("from Employee where calification > :c").setParameter("c", calification).getResultList();
        } catch (Exception e) {
            throw new RealStateExcepction(e.getMessage());
        }
    }
}
