package com.riyadbusttami.dojoninjasassignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyadbusttami.dojoninjasassignment.models.Ninja;
@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
public List<Ninja> findAll();
}
