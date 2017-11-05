/**
 * 
 */
package com.gp.graphqlaggregator.graphql.datafetcher;

import java.util.List;
import java.util.Map;

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
public class UserAccountByPANAndEntityDataFetcher implements DataFetcher<User> {
	
	@Autowired
	UserRepository repo;
	
	@Override
	public User get(DataFetchingEnvironment environment) {
		Map argMap= environment.getArguments();
		String panId=(String)argMap.get("pan");
		Integer entityId=(Integer)argMap.get("entityid");
		List<User> users=repo.findByPanidAndEntityid(panId, entityId);
		User user=null;
		if(!users.isEmpty()){
			user=users.get(0);
		}
		return user;
	}

}
