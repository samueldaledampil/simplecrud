package com.example.SimpleCrud.service;

import com.example.SimpleCrud.model.Employee;
import com.example.SimpleCrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> listAll(){
        return repo.findAll();
    }

    public void save (Employee emp){
        repo.save(emp);
    }

    public Employee get(long id){
        return repo.findById(id).get();
    }

    public void delete(long id){
        repo.deleteById(id);
    }
}
