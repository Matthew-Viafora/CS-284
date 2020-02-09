package Binary;
import java.util.Arrays;
import java.lang.Math;
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
	

	
		
	public int[] getInnerArray() {
		return data;
		
		
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
	
	public int toDecimal() {
		int total =0;
		
		for (int i =0; i < this.length; i++) {
			total+= data[i]*Math.pow(2, length-i-1);
			
			
			
		}
		return total;
		
		
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
	
	public void bitShift(int direction, int amount) {
		
		if (direction == 1) {
			prepend(amount);
		}
		if (direction == -1) {
			for (int i = length-amount; i< length; i++) {
				data[i]=0;
				
				
			}
			
		}
		//Implement Error message here
	}
	
	
	static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		
		int a[] = bn1.getInnerArray();
		int b[] = bn2.getInnerArray();
		int c[] =  new int [bn1.getLength()];
		
		for (int i = 0; i < bn1.getLength(); i++) {
			if (a[i]== 0 && b[i] == 0) {
				c[i] = 0;
			}
			if (a[i]== 1 && b[i] == 0) {
				c[i] = 1;
			}
			if (a[i]== 0 && b[i] == 1) {
				c[i] = 1;
			}
			if (a[i]== 1 && b[i] == 1) {
				c[i] = 1;
			}
		
		
			
			
		}
		return c;
		
		
		
	}
	
	static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		
		int a[] = bn1.getInnerArray();
		int b[] = bn2.getInnerArray();
		int c[] =  new int [bn1.getLength()];
		
		
		
		
		for (int i = 0; i < bn1.getLength(); i++) {
			if (a[i]== 0 && b[i] == 0) {
				c[i] = 0;
			}
			if (a[i]== 1 && b[i] == 0) {
				c[i] = 0;
			}
			if (a[i]== 0 && b[i] == 1) {
				c[i] = 0;
			}
			if (a[i]== 1 && b[i] == 1) {
				c[i] = 1;
			}
			
			
		
	}
		
		return c;		
		}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNumber myobj1 = new BinaryNumber("1000");
		BinaryNumber myobj2 = new BinaryNumber("0011");
		//System.out.println(Arrays.toString(myobj.data));
		System.out.println(Arrays.toString(myobj2.data));
		System.out.println(myobj2.getLength());
		System.out.println(myobj2.getDigit(4));
		System.out.println(myobj2.toDecimal());
		//myobj2.bitShift(-1, 2);
		System.out.println(Arrays.toString(myobj2.data));
		System.out.println(Arrays.toString(bwor(myobj1, myobj2)));
		
		
		

	}
	
}
		


				
				
	






	

		
		
		
	
	
	
	
	
	
	


