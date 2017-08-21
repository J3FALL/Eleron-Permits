package com.pavel.permits.permits.core.service.impl;

import com.pavel.permits.permits.core.service.PermitService;
import com.pavel.permits.permits.model.Permit;
import com.pavel.permits.permits.persistence.repository.PermitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pavel on 21.08.2017.
 */

@Service
public class PermitServiceImpl implements PermitService {

    @Autowired
    private PermitRepository repository;

    public PermitServiceImpl(PermitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Permit> findAll() {
        return repository.findAll();
    }

    @Override
    public Permit findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Permit save(Permit permit) {
        return repository.save(permit);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
