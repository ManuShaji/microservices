package com.project.ContactmanagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ContactmanagementSystem.bean.Person;
@Repository
public interface ContactRepository extends JpaRepository<Person, Integer> {

}
