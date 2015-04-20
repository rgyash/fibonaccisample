package com.emc.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.example.exception.FibonacciServiceException;
import com.emc.example.service.FibonacciService;

@Controller
@RequestMapping( value = "/fibonacci" )
public class FibonacciServiceController {

   @Autowired
   private FibonacciService service;

   @RequestMapping(value = "/{seriesOFNumber}", 
		           method = RequestMethod.GET )
   @ResponseBody
   public ResponseEntity<String> findSeriesofFibonacciNums( @PathVariable( "seriesOFNumber" ) Integer seriesOFNumber ){
	   try {
		   return new ResponseEntity<String>(service.findSeriesofFibonacciNums(seriesOFNumber),HttpStatus.OK);
	   } catch ( FibonacciServiceException fse) {
		   return new ResponseEntity<String>(fse.getMessage(),  HttpStatus.BAD_REQUEST);
	   }
   }    

}