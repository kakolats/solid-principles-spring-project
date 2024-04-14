package com.example.solidproject.repository.list;

import com.example.solidproject.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    List<Service> services =new ArrayList<>();

    public Service findByCode(String code){
        return services.stream().filter(c->c.getCode().compareToIgnoreCase(code)==0).findFirst().orElse(null);
    }

    public void save(Service service){
        services.add(service);
    }

    public List<Service> findAll(){
        return services;
    }
}
