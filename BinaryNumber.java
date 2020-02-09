package Binary;
import java.lang.Math;
import java.util.Arrays;
import java.lang.*;

public class BinaryNumber {
	int data[];
	int length;
	
	public BinaryNumber(int length) {
		
		data = new int [length];
		this.length = length;
		
		
		for(int i = 0; i < length; i++) {
			data[i] = 0;
		
		}
		
	}
	
	public BinaryNumber(String str) {
		
		this.length=str.length();
		data = new int [length];
		
		
		for (int i = 0; i <length; i++) {
			data[i] = str.charAt(i);
		}
		for (int j =0; j<length; j++) {
			data[j] = java.lang.Character.getNumericValue(data[j]);
				
				
			}
		}
	
	public int getLength() {
		
		return data.length;
	}
	
		
	public int[] getInnerArray() {
		return data;
		
		
	}
	
	
	public int getDigit(int index) {
			try{
				return data[index];
			}
			catch(Exception e) {
				System.out.println("Index is out of range");
				return -1;
				
			}
			
		}
	
	public int toDecimal() {
		int total =0;
		
		for (int i =0; i < this.length; i++) {
			total+= data[i]*Math.pow(2, length-i-1);
			
			
			
		}
		return total;
		
		
	}
	
	public void bitShift(int direction, int amount) {
		
		
	}
	
	
					
		
		
	}
	
	
	
	
	


