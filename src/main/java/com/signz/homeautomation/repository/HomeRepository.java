package com.signz.homeautomation.repository;

import com.signz.homeautomation.model.Home;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends PagingAndSortingRepository<Home, Integer> {
}
