package com.gp.graphqlaggregator.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.graphqlaggregator.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
