package playground;

public class I2 {

	public static void main(String[] args) {
	
		
		int var1 = 4;
		
		int var2 = 5;
		
		
		swap(var1, var2);
		
		
	}
	
	public static void swap(int var1, int var2) {
		
		var1 = var2 + var1;
		
		var2 = var1 - var2;
		
		var1 = var1-var2;
		
		System.out.println(var1);
		System.out.println(var2);
		
	}
	
	
	

}
