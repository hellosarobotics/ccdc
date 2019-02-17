package com.sarobotics.ccdc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sarobotics.ccdc.service.CheckDigitCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CcdcApplicationTests {
	
	@Autowired
	CheckDigitCalculator cdc;
	

	  @Test
	  public void calcolaCheckDigit(){
	    int checkDigit = cdc.CalculateCheckDigit("CAIU9270631");
	    assertEquals(1, checkDigit);
	  }
	  
	  @Test
	  public void isCorrect(){
	    int checkDigit = cdc.CalculateCheckDigit("CAIU9270631");
	    boolean b = cdc.isCorrect(checkDigit, "CAIU9270631");
	    assertEquals(true, b);
	  }

}

