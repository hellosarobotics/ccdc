package com.sarobotics.ccdc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sarobotics.ccdc.service.CheckDigitCalculator;
import com.sarobotics.ccdc.service.CheckDigitCalculatorImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CcdcApplicationTests {

	  @Test
	  public void calcolaCheckDigit(){
		CheckDigitCalculator cdc = new CheckDigitCalculatorImpl();
	    int checkDigit = cdc.CalculateCheckDigit("MSKU5787975");
	    assertEquals(5, checkDigit);
	  }

}

