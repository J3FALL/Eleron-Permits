package com.pavel.permits.permits.core.service.impl;

import com.pavel.permits.permits.core.service.CodeService;
import com.pavel.permits.permits.model.Code;
import com.pavel.permits.permits.persistence.repository.CodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pavel on 21.08.2017.
 */

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeRepository repository;

    public CodeServiceImpl(CodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Code> findAll() {
        return repository.findAll();
    }

    @Override
    public Code findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Code save(Code code) {
        return repository.save(code);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
