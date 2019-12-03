package com.codingdojo.studrost.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studrost.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
