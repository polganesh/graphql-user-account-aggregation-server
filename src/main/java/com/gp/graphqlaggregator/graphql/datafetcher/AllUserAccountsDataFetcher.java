/**
 * 
 */
package com.gp.graphqlaggregator.graphql.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gp.graphqlaggregator.entity.User;
import com.gp.graphqlaggregator.repo.UserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author GANESH
 *
 */
@Component
public class AllUserAccountsDataFetcher implements DataFetcher<List<User>> {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> get(DataFetchingEnvironment env) {
		List<User> u=userRepo.findAll();
		return u;
	}
}
