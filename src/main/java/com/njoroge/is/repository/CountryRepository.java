package com.njoroge.is.repository;

import org.springframework.data.repository.CrudRepository;

import com.njoroge.is.domain.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
