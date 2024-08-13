package com.jpaappj3.jpa_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpaappj3.jpa_app.entities.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> findByProgrammingLanguage(String programmingLanguage,String name);
}
