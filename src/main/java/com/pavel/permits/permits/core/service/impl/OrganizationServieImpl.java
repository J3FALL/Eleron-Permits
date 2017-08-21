package com.pavel.permits.permits.core.service.impl;

import com.pavel.permits.permits.core.service.OrganizationService;
import com.pavel.permits.permits.model.Organization;
import com.pavel.permits.permits.persistence.repository.OrganizationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pavel on 21.08.2017.
 */

@Service
public class OrganizationServieImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository repository;

    public OrganizationServieImpl(OrganizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Organization> findAll() {
        return repository.findAll();
    }

    @Override
    public Organization findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Organization save(Organization organization) {
        return repository.save(organization);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
