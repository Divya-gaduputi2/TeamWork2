package com.adb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adb.model.GroupEntity;

@Repository
public interface GroupRepositary extends JpaRepository<GroupEntity, String> {

}
