package com.cosplayevent.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CostumeRepository extends JpaRepository<Costume, Integer> {
    List<Costume> findByEvent(Event event);   //findby is a built in
}
