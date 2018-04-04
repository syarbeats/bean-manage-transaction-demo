/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdc.mitrais.service;

import com.cdc.mitrais.entity.Employee;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author Syarif_H657
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeService implements EmployeeServiceLocal, EmployeeServiceRemote {

    @PersistenceContext(unitName = "EAIApp-ejbPU")
    EntityManager entityManager;

    @Resource
    UserTransaction tx;

    public EmployeeService() {

    }

    public Employee createEmployee(String name, String surname, String title, double salary) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setTitle(title);
        employee.setSalary(salary);
        employee.setCreated(new Date());

        try {
            try {
                tx.begin();
                entityManager.persist(employee);
            } catch (Exception e) {

            } finally {
                tx.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return employee;
    }

    public void removeEmployee(long id) {
        Employee employee = findEmployee(id);

        if (employee != null) {

            try {
                try {
                    tx.begin();
                    entityManager.remove(employee);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    tx.commit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Employee promoteEmployee(long id, String newTitle, double newSalary) {
        Employee employee = entityManager.find(Employee.class, id);

        if (employee != null) {
            employee.setTitle(newTitle);
            employee.setSalary(newSalary);

            try {
                try {
                    tx.begin();
                    entityManager.merge(employee);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    tx.commit();
                }
            } catch (Exception e) {

            }
        }

        return employee;
    }

    public Employee findEmployee(long id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAllEmployee() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }
}
