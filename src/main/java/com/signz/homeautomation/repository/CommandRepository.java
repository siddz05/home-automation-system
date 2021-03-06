package com.signz.homeautomation.repository;

import com.signz.homeautomation.model.Command;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author siddharthdwivedi
 */
@Repository
public interface CommandRepository extends PagingAndSortingRepository<Command, Integer> {
}
