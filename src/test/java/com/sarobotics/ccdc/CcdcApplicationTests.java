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
	  public void calcolaCheckDigitSEA(){
	    int checkDigit = cdc.CalculateCheckDigit("CAIU9270631");
	    assertEquals(1, checkDigit);
	  }
	  
	  @Test
	  public void isCorrectSEA(){
	    int checkDigit = cdc.CalculateCheckDigit("CAIU9270631");
	    boolean b = cdc.isCorrect(checkDigit, "CAIU9270631");
	    assertEquals(true, b);
	  }

	  @Test
	  public void calcolaCheckDigitAIR(){
	    int checkDigit = cdc.calculateCheckDigitAIR("900-03434395");
	    assertEquals(5, checkDigit);
	  }
	  
	  @Test
	  public void isCorrectAIR(){
	    int checkDigit = cdc.calculateCheckDigitAIR("900-03434395");
	    boolean b = cdc.isCorrect(checkDigit, "900-03434395");
	    assertEquals(true, b);
	  }
	  
	  @Test
	  public void isCorrectAIRFinalZero(){
		  int checkDigit = cdc.calculateCheckDigitAIR("057-69044010");
		  boolean b = cdc.isCorrect(checkDigit, "057-69044010");
		  assertEquals(true, b);
	  }


}

