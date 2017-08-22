package com.pavel.permits.permits.core.service.impl;

import com.pavel.permits.permits.core.service.PassService;
import com.pavel.permits.permits.model.Pass;
import com.pavel.permits.permits.persistence.repository.PassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pavel on 21.08.2017.
 */

@Service
public class PassServiceImpl implements PassService {

    @Autowired
    private PassRepository repository;

    public PassServiceImpl(PassRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pass> findAll() {
        return repository.findAll();
    }

    @Override
    public Pass findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Pass save(Pass pass) {
        return repository.save(pass);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
