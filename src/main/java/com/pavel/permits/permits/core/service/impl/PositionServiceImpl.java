package com.pavel.permits.permits.core.service.impl;

import com.pavel.permits.permits.core.service.PositionService;
import com.pavel.permits.permits.model.Position;
import com.pavel.permits.permits.persistence.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pavel on 21.08.2017.
 */

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository repository;

    public PositionServiceImpl(PositionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Position> findAll() {
        return repository.findAll();
    }

    @Override
    public Position findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Position save(Position position) {
        return repository.save(position);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
