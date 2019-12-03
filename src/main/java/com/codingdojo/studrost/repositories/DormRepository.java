package com.codingdojo.studrost.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studrost.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long>{

}
