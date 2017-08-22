package com.pavel.permits.permits.persistence.repository;

import com.pavel.permits.permits.model.Permit;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Pavel on 21.08.2017.
 */
public interface PermitRepository extends JpaRepository<Permit, Integer> {

}
