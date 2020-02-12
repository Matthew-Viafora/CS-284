
package Binary;
import java.util.Arrays;
import java.lang.Math;
import java.lang.*;
//Matthew Viafora Binary Assignment

public class BinaryNumber {
	private int data[];
	private int length;

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
	
    public int getDigit(int index) {
		try{
			return data[index];
		}
		catch(Exception e) {
			System.out.println("Index is out of range");
			return -1;
			
		}
		
	}
    
    public int[] getInnerArray() {
		return data;
		
		
	}
    
    
    static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		
		int a[] = bn1.getInnerArray();
		int b[] = bn2.getInnerArray();
		int c[] =  new int [bn1.getLength()];
		
		if (bn1.getLength()==bn2.getLength()) {
		for (int i = 0; i < bn1.getLength(); i++) {
			c[i]=a[i] | b[i];
		}
		return c;
			
			
		}
		else {
			System.out.println("Error: Arrays are not of same length");
			return c;
		}
		
	}
    
    static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		
		int a[] = bn1.getInnerArray();
		int b[] = bn2.getInnerArray();
		int c[] =  new int [bn1.getLength()];
		
		if (bn1.getLength()==bn2.getLength()) {
		for (int i = 0; i < bn1.getLength(); i++) {
			c[i]=a[i] & b[i];
		}
		return c;	
		
	}
		else {
			System.out.println("Error: Arrays are not of same length");
			return c
					;
		}
		
		
		}
    
    
    public void bitShift(int direction, int amount) {
		
		if (direction == 1) {
			prepend(amount);
		}
		else if (direction == -1) {
			int[] bshift = new int[length-amount];
			for (int i = 0; i< bshift.length; i++) {
				if (i>=length) {
					bshift[i] = 0;
					
				
			}
				else {
					bshift[i]=data[i];
				}
				
				data = bshift;	
			}
			
		}
	}
    
	
	public void prepend(int amount) {
		int addedAmount[] = new int [amount];
		for(int i = 0; i < amount; i++) {
			addedAmount[i] = 0;
		}
		int fal = data.length;
		int sal = addedAmount.length;
		int[] result = new int[fal+sal];
		System.arraycopy(data, 0, result, 0, fal);
		System.arraycopy(addedAmount, 0, result, fal, sal);
		
		data = result;
	}
	
	
	
	
	
	public void reversePrepend(int amount) {
		int addedAmount[] = new int [amount];
		for(int i = 0; i < amount; i++) {
			addedAmount[i] = 0;
		}
		int sal = data.length;
		int fal = addedAmount.length;
		int[] result = new int[fal+sal];
		System.arraycopy(addedAmount, 0, result, 0, fal);
		System.arraycopy(data, 0, result, fal, sal);
		
		data = result;
	}
	
	
	void add (BinaryNumber a) {
		
		if(length < a.getLength()) {
			reversePrepend(a.getLength()-length);
		}
		else if (a.getLength()< length) {
			a.reversePrepend(length-a.getLength());
			
		}
		
		int carry = 0;
		for (int i = length; i >= 1; i--) {
			if (data[i-1] == 1 && a.getInnerArray()[i-1]==0) {
				if (1+carry == 2) {
					data[i-1] = 0;
				}
				else{
				data[i-1]=1;
				carry = 0;
				}
			}
			else if (data[i-1] == 0 && a.getInnerArray()[i-1]==1) {
				if (1+carry == 2) {
					data[i-1] = 0;
				}
				else{
				data[i-1]=1;
				carry = 0;
				}
			}
			else if (data[i-1]==1 && a.getInnerArray()[i-1]==1) {
				if (carry == 1) {
					
					data[i-1]=1;
					
				}
				else{
				data[i-1]=0;
				carry = 1;
				}
			}
			
			else if (data[i-1]==0 && a.getInnerArray()[i-1]==0) {
				if (carry ==1) {
					data[i-1]=1;
					carry = 0;
				}
				else {
					data[i-1]=0;
				}
			}
			}
		if (carry == 1) {
		try {
			data[0-1]=0;
		}
		catch(Exception e) {
			
			reversePrepend(1);
			
			data[0]=1;
		}
		}
			
					
				}
	
	
	public int toDecimal() {
		int total =0;
		
		for (int i =0; i < this.length; i++) {
			total+= data[i]*Math.pow(2, length-i-1);
			
		}
		return total;
		
		
	}
	
	public String toString() {
		String str ="";
		for (int i=0;i<length ;i++) {
		str+=data[i];
		}
		return str;
		
		
	}
	
	
	
	
	
	
}
		


				
				
	






	

		
		
		
	
	
	
	
	
	
	


