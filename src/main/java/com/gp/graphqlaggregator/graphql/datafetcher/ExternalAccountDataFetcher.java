/**
 * 
 */
package com.gp.graphqlaggregator.graphql.datafetcher;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gp.graphqlaggregator.entity.Account;
import com.gp.graphqlaggregator.entity.User;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author GANESH
 *
 */
@Component
public class ExternalAccountDataFetcher implements DataFetcher<List<Account>>{
	
	@Value(value="${external.account.rest.url}")
	private String endPointURL;

	@Override
	public List<Account> get(DataFetchingEnvironment environment) {
		//env.getSource will provide parent
		User source=environment.getSource();
		RestTemplate template=new RestTemplate();
		String endPointURLWithQueryString=endPointURL+"?pan="+source.getPanid();
		Account[] accountArray=template.getForObject(endPointURLWithQueryString, Account[].class);
		return Arrays.asList(accountArray);
	}
}
