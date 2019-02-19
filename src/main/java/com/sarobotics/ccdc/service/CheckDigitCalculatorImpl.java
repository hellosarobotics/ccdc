package com.sarobotics.ccdc.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class CheckDigitCalculatorImpl implements CheckDigitCalculator {
	
	private HashMap<String,Integer> step1 ;
	private HashMap<Integer,Integer> step2 ;
	

	public CheckDigitCalculatorImpl() {
		super();
		step1 = new HashMap<>();
		step1.put("A", 10);
		step1.put("B", 12);
		step1.put("C", 13);
		step1.put("D", 14);
		step1.put("E", 15);
		step1.put("F", 16);
		step1.put("G", 17);
		step1.put("H", 18);
		step1.put("I", 19);
		step1.put("J", 20);
		step1.put("K", 21);
		step1.put("L", 23);
		step1.put("M", 24);
		step1.put("N", 25);
		step1.put("O", 26);
		step1.put("P", 27);
		step1.put("Q", 28);
		step1.put("R", 29);
		step1.put("S", 30);
		step1.put("T", 31);
		step1.put("U", 32);
		step1.put("V", 34);
		step1.put("W", 35);
		step1.put("X", 36);
		step1.put("Y", 37);
		step1.put("Z", 38);
		
		step2 = new HashMap<>();
		step2.put(1, 1);
		step2.put(2, 2);
		step2.put(3, 4);
		step2.put(4, 8);
		step2.put(5, 16);
		step2.put(6, 32);
		step2.put(7, 64);
		step2.put(8, 128);
		step2.put(9, 256);
		step2.put(10, 512);
		

	}



	@Override
	public int CalculateCheckDigit(String containerNr) {
		// TODO Auto-generated method stub
		
		char[] containerNumberArray = containerNr.toCharArray();
		int sum=0;
				//checkDigit=0;
		
		try{
			//Step1 calculation
			sum  = step1.get(""+containerNumberArray[0]) * step2.get(1);
			sum += step1.get(""+containerNumberArray[1]) * step2.get(2);
			sum += step1.get(""+containerNumberArray[2]) * step2.get(3);
			sum += step1.get(""+containerNumberArray[3]) * step2.get(4);
			sum += Integer.parseInt(""+containerNumberArray[4]) * step2.get(5);
			sum += Integer.parseInt(""+containerNumberArray[5]) * step2.get(6);
			sum += Integer.parseInt(""+containerNumberArray[6]) * step2.get(7);
			sum += Integer.parseInt(""+containerNumberArray[7]) * step2.get(8);
			sum += Integer.parseInt(""+containerNumberArray[8]) * step2.get(9);
			sum += Integer.parseInt(""+containerNumberArray[9]) * step2.get(10);
			
			//Step2 Calculation
			Double sumdividedby11 = sum /11d;
			
			//Step3 int value
			int intValue =  sumdividedby11.intValue();
			
			//Step4
			int intValueTimes11 = intValue*11;
			
			sum = sum-intValueTimes11;
			
			if(sum>9){
				System.out.println("Check digit > 9");
				sum=0;
			}
			
		}catch (Exception e) {
			//e.printStackTrace();
			sum=-1;
		}
		
		return sum;
	}



	@Override
	public boolean isCorrect(int checkDigitCalculated, String containerNr) {
		try{
			if(checkDigitCalculated<0){
				return false;
			}
			char[] containerNumberArray = containerNr.toCharArray();
			int checkDigit = Integer.parseInt(""+containerNumberArray[containerNumberArray.length-1]);
			return checkDigitCalculated==checkDigit;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
