package assign_3_4;

import java.util.Scanner;

/* @author Shariff Mohammed & Justin Lee
 */

public class SmartARDriver 
{

	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		int keyIn;
		String input;
		SmartAR sAR = new SmartAR(10, 6);
		
		
		System.out.println("Input the number of keys you wish to generate:");
		keyIn = kb.nextInt();
		
		sAR.generate(keyIn);
		System.out.println("Your following car list will be: \n"); sAR.print();
		System.out.print("\n");
		System.out.println("Input desired operation or type 'exit' to quit.");
		
		while(true)
		{
	        input = kb.nextLine();
	        
	        if(input.equals("next key"))
	        {
	        	System.out.print("\n");
	        	System.out.println("Select the desired key");
	        	System.out.print("KEY: "); input = kb.nextLine();
	        	System.out.print("\n");
	        	System.out.println("The next key of "+input+" is: "+sAR.nextKey(input));
	        	System.out.println("Input desired operation or type 'exit' to quit.");
	        }
	        
	        else if(input.equals("prev key"))
	        {
	        	System.out.print("\n");
	        	System.out.println("Select the desired key");
	        	System.out.print("KEY: "); input = kb.nextLine();
	        	System.out.print("\n");
	        	System.out.println("The previous key of "+input+" is: "+sAR.prevKey(input));
	        	System.out.println("Input desired operation or type 'exit' to quit.");
	        }
	        
	        else if(input.equals("prev cars"))
	        {
	        	System.out.print("\n");
	        	System.out.println("Select the key you wish to see the history of: ");
	        	System.out.print("KEY: "); input = kb.nextLine();
	        	System.out.print("\n");
	        	System.out.println("All of the previous cars of this key in reverse chronological order is: \n"+sAR.previousCars(input));
	        	System.out.print("\n");
	        	System.out.println("Input desired operation or type 'exit' to quit.");
	        }
	        
	        else if(input.equals("change value"))
	        {
	        	System.out.print("\n");
	        	System.out.println("select a key and its new name:");
	        	System.out.print("\n");
	        	System.out.print("KEY: "); input = kb.nextLine();
	        	System.out.print("VALUE: ");String name = kb.nextLine();
	        	
	        	sAR.changeValue(input, name); 
	        	System.out.println("\n");
	        	System.out.println("The new list will be: ");
	        	sAR.print();
	        	System.out.print("\n");
	        	System.out.println("Input desired operation or type 'exit' to quit.");
	        }
	        
	        else if(input.equals("find value"))
	        {
	        	System.out.print("\n");
	        	System.out.println("select a key in the list:");
	        	input = kb.nextLine();
	        	
	        	System.out.println("The value for this key is: "+sAR.getValues(input)); 
	        	System.out.println("Input desired operation or type 'exit' to quit.");
	        }
	        
	        else if(input.equals("all keys"))
	        {
	        	System.out.print("\n");
	        	System.out.println("All the keys in your car list will be:");
	        	System.out.println(sAR.allKeys());
	        	System.out.print("\n");
	        	System.out.println("Input desired operation or type 'exit' to quit.");
	        }
	        
	        
	        else if(input.equals("generate"))
	        {
	        	System.out.print("\n");
	        	System.out.println("Input the number of keys you wish to generate");
	        	keyIn = kb.nextInt();
	        	
	        	sAR.generate(keyIn);
	        	System.out.println("Your new list will be"); sAR.print();
	        	System.out.print("\n");
	        	System.out.println("Input desired operation or type 'exit' to quit.");
	        }
	        
	        else if(input.equals("remove"))
	        {
	        	System.out.print("\n");
	        	System.out.println("select the key you want to remove:");
	        	input = kb.nextLine();
	        	sAR.remove(input);
	        	System.out.println("Your new list will be"); sAR.print();
	        	System.out.print("\n");
	        	System.out.println("Input desired operation or type 'exit' to quit.");
	        	
	        }
	        
	        else if(input.equals("print car list"))
	        {
	        	System.out.print("\n");
	        	System.out.println("The car objects in your list are");
	        	sAR.print();
	        	System.out.print("\n");
	        	System.out.println("Input desired operation or type 'exit' to quit.");
	        }
	        
	        else if(input.equals("exit"))
	        {
	        	System.out.println("program terminated!");
	        	System.exit(0);
	        }
	        
		}
	}

}
