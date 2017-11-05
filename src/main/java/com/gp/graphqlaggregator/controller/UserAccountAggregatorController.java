package com.gp.graphqlaggregator.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.hadoop.hdfs.server.datanode.dataNodeHome_jsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gp.graphqlaggregator.graphql.alluseraccounts.AllUserAccountsDataFetcher;
import com.gp.graphqlaggregator.graphql.alluseraccounts.UserAccountByPANAndEntityDataFetcher;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.language.TypeName;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.RuntimeWiring.Builder;
import javafx.util.BuilderFactory;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
//import graphql.schema.idl.TypeRuntimeWiring.Builder;
import graphql.schema.idl.TypeRuntimeWiring;

@RestController
public class UserAccountAggregatorController {

	@Value("classpath:userAccountSchema.graphqls")
	private Resource schemaResource;
	
	private GraphQL graphQL;
	
	@Autowired
	private AllUserAccountsDataFetcher allUserAccountsDataFetcher;
	@Autowired
	private UserAccountByPANAndEntityDataFetcher userAccountByPANAndEntityDataFetcher;
	
	public UserAccountAggregatorController() {
		// TODO Auto-generated constructor stub
	}
	//http://graphql-java.readthedocs.io/en/v5/schema.html
	@PostConstruct
	public void loadSchemaFromClasspath() throws IOException{
		File schemaFile=schemaResource.getFile();
		SchemaParser parser=new SchemaParser();
		TypeDefinitionRegistry registry=parser.parse(schemaFile);
		RuntimeWiring wiring=buildWiring();
		GraphQLSchema graphQLSchema=new SchemaGenerator().makeExecutableSchema(registry, wiring);
		graphQL=GraphQL.newGraphQL(graphQLSchema).build();
	}
	
	private RuntimeWiring buildWiring(){
		return RuntimeWiring.newRuntimeWiring().
				type(	"Query", 
						typeWiring->typeWiring.
						dataFetcher("allUserAccounts", allUserAccountsDataFetcher).
						dataFetcher("userAccountByPANAndEntity", userAccountByPANAndEntityDataFetcher)).
				build();
	}

//	@RequestMapping(value = "graphiql", method = RequestMethod.POST, produces = {
//	"application/json" }, headers = "Accept=application/json")
//	public ResponseEntity graphiql(@RequestBody String query){
//		return getResult(query);
//	}
//	
//	@RequestMapping(value = "graphql", method = RequestMethod.POST, produces = {
//	"application/json" }, headers = "Accept=application/json")
//	public ResponseEntity graphql(@RequestBody String query){
//		return getResult(query);
//	}

	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = {
	"application/json" }, headers = "Accept=application/json")
	public ResponseEntity query(@RequestBody String query){
		return getResult(query);
	}
	
	private ResponseEntity getResult(String query){
		ExecutionResult result=graphQL.execute(query);
		if(!result.getErrors().isEmpty()){
			System.err.println(" "+result.getErrors().toString());
		}
		return ResponseEntity.ok(result.getData());
	}

}
