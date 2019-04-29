package com.sarobotics.ccdc.restcontroller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarobotics.ccdc.service.CheckDigitCalculator;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1")
public class CcdcController {
	
	@Autowired
	CheckDigitCalculator cdc;
	
	@CrossOrigin
	@RequestMapping(value = "/ccdc/{container_nr}", method = GET)
	@ApiOperation(value = "Validate the container number.")
	public boolean canCommunicate( @PathVariable( name = "container_nr" ) String containerNr) {
		
		containerNr = containerNr.trim().replace(" ", "");
		
		// Identificazione Container SEA oppure AIR
		// Se i primi 4 caratteri sono lettere allora e' un container sea altrimenti e' air
		String sea="^([A-Z]){3}[U,J,Z]([0-9]){7}$";	// Variable Name 1
		String air="^([0-9]){3}[-]([0-9]){8}$";

	    Pattern psea = Pattern.compile(sea,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher msea = psea.matcher(containerNr);
	    Pattern pair = Pattern.compile(air,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher mair = pair.matcher(containerNr);
	    
	    if (msea.find())
	    {
	    	// Container sea
	    	int checkDigitCalculated = cdc.CalculateCheckDigit(containerNr);
	    	return cdc.isCorrect(checkDigitCalculated,containerNr);

	    }else if(mair.find()){
	    	int checkDigitCalculated = cdc.calculateCheckDigitAIR(containerNr);
	    	return cdc.isCorrect(checkDigitCalculated,containerNr);
	    	
	    }else{
	    	return false;
	    }
	    
		
	}

}
