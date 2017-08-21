package com.pavel.permits.permits.persistence.repository;

import com.pavel.permits.permits.model.Permit;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel on 21.08.2017.
 */
public interface PermitRepository extends CrudRepository<Permit, Integer> {

}
