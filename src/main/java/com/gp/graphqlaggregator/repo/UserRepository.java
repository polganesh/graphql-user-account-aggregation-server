package com.gp.graphqlaggregator.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.graphqlaggregator.entity.User;
import java.lang.String;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByPanidAndEntityid(String panid,Integer entityId);
}
