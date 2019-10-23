package com.example.listdemo.services;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListService {

	private String jepordyUrl = "http://jservice.io/api/categories?count=20";
	
	@Autowired
	OpenApiRequestor requestor;
	
	@CrossOrigin()
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ResponseEntity<ListResult> getList(){
		
		ListResult list = new ListResult();
		
		try {
			list = requestor.makeJeapordyRequest(jepordyUrl);
			
		} catch (UnsupportedOperationException | IOException e) {
			System.out.println("Error: " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
}
