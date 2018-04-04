/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdc.mitrais.service;

import com.cdc.mitrais.entity.Employee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Syarif_H657
 */
@Local
public interface EmployeeServiceLocal {

    public Employee createEmployee(String name, String surname, String title, double salary);

    public void removeEmployee(long id);

    public Employee promoteEmployee(long id, String newTitle, double newSalary);

    public Employee findEmployee(long id);

    public List<Employee> findAllEmployee();
}
