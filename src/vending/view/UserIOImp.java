package vending.view;

import java.util.Scanner;

public class UserIOImp implements UserIO{
	
    static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    @Override
    public String readString(String prompt) {
    	System.out.print(prompt);
    	String in = sc.nextLine();
    	return in;
    }
    @Override
    public int readInt(String prompt) {
    	System.out.print(prompt);
    	int in = Integer.parseInt(sc.nextLine());
    	return in;
    }
   @Override
   public long readLong(String prompt) {
   	System.out.print(prompt);
   	long in = Long.parseLong(sc.nextLine());
   	return in;
   }
}
