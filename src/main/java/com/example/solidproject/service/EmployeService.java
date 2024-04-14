package com.example.solidproject.service;

import com.example.solidproject.entity.Employe;
import com.example.solidproject.entity.Service;
import com.example.solidproject.repository.list.EmployeRepository;

import java.util.List;

public class EmployeService {
    EmployeRepository employeRepository = new EmployeRepository();

    public Employe getByMatricule(String code){
        return employeRepository.findByMatricule(code);
    }

    public void add(Employe employe){
        employe.setMatricule("EMP00"+employe.getId());
        employeRepository.save(employe);
    }

    public List<Employe> getAll(){
        return employeRepository.findAll();
    }
}
