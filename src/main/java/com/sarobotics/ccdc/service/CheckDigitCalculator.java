package com.sarobotics.ccdc.service;


public interface CheckDigitCalculator {
	
	int CalculateCheckDigit(String containerNr);

	boolean isCorrect(int checkDigitCalculated, String containerNr);

	
}
