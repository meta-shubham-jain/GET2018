package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;

/**
 * The class implements basedao interface methods
 * 
 * @author Shubham Jain
 *
 */
@Repository
@Transactional
public class EmployeeDao implements EmployeeDaoInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee getById(int code) {
        @SuppressWarnings("deprecation")
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                Employee.class);
        criteria.add(Restrictions.eq("empCode", code));
        criteria.add(Restrictions.eq("enabled", true));
        return (Employee) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAll() {
        @SuppressWarnings("deprecation")
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                Employee.class);
        criteria.add(Restrictions.eq("enabled", true));
        return criteria.list();
    }

    @Override
    public Status create(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
        return Status.INSERTED;
    }

    @Override
    public Status update(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return Status.UPDATED;
    }

    @Override
    public Status delete(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return Status.DELETED;
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Employee> getEmployeeByName(String firstName, String lastName) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                Employee.class);
        criteria.add(Restrictions.eq("enabled", true));
        criteria.add(Restrictions.eq("firstName", firstName));
        criteria.add(Restrictions.eq("lastName", lastName));
        return criteria.list();
    }

    public Status checkValidCredentials(String email, String password) {
        return Status.OK;
    }

    public Employee getEmployeeByEmail(String email) {
        @SuppressWarnings("deprecation")
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                Employee.class);
        criteria.add(Restrictions.eq("email", email));
        return (Employee) criteria.uniqueResult();
    }

    public Employee getEmployeeMaxId() {
        @SuppressWarnings("deprecation")
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                Employee.class);
        criteria.addOrder(Order.desc("empCode"));
        criteria.setMaxResults(1);
        return (Employee) criteria.uniqueResult();
    }

    public List<Employee> getEmployeeBySkills(int id) {
        Employee em = new Employee();
        TypedQuery<Employee> query = sessionFactory
                .getCurrentSession().createQuery("Select e from Employee e, EmployeeSkills es , SkillsMaster sm where e.empCode = es.empCode AND sm.skillId = es.skillCode AND sm.skillId = :id");
        query.setParameter("id", id);
        return (List<Employee>) query.getResultList();
    }
}