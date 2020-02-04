package com.example.s07j2eetp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.s07j2eetp.entity.Section;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> { }
