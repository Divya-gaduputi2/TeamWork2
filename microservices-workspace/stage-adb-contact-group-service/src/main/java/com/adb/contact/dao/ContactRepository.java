package com.adb.contact.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adb.contact.model.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

}
