package com;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class OptionMenu extends Account 
{
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'Rs: '###,##0.00/-");
	int selection;
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	// Validate Login information customer number and pin number.
	public void getLogin() throws IOException
	{
		int x=1;
		
		do 
		{
			try
			{
				data.put(98975642, 5875);
				data.put(75984621, 1691);
				data.put(69871354, 4598);
				
				System.out.println("Welcome to ATM Machine!!");
				
				System.out.print("Enter your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.print("Enter your Pin Number: ");
				setPinNumber(menuInput.nextInt());
			}
			catch(Exception e)
			{
				System.out.println("\n" + "Invalid character(s). enter only NUMBERS." + "\n");
				x=2;
			}
			
			// Checking weather entered customer number and pin number is correct or not 
			for(Entry<Integer, Integer> entry : data.entrySet())
			{
				if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber())
				{
					getAccountType();
				}
		
			}
			
			System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
			
		}while(x==1);
		
	}// here getLogin() method ends
	
	//Display Account type menu with selection
	public void getAccountType()
	{
		System.out.println("\n" + "Select the Account you want to Access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.print("Choice: ");
		
		selection = menuInput.nextInt();
		
		switch(selection)
		{
			case 1:
				getChecking();
				break;
				
			case 2:
				getSaving();
				break;
				
			case 3:
				System.out.println("\n" + "Thank you for using this ATM, Bye" + "\n");
				try 
				{
					getLogin();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				break;	
				
			default:
				System.out.println("\n" + "Invalid Choice" +"\n");
				getAccountType();
		}
	}// here getAccountType method ends, it happens after user has successfully login
	
	// Display Checking Account menu with selections
	public void getChecking()
	{
		System.out.println("\n" + "Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");
		
		selection = menuInput.nextInt();
		
		switch(selection)
		{
			case 1:
				System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
				getAccountType();
				break;
				
			case 2:
				getCheckingWithdrawInput();
				getAccountType();
				break;
				
			case 3:
				getCheckingDepositInput();
				getAccountType();
				break;
				
			case 4:
				System.out.println("Thank you for using this ATM, Bye");	
				
			default:
				System.out.println("\n" + "Invalid Choice" +"\n");
				getChecking();
		}
	}// here getChecking method ends
	
	//Display saving Account menu with selections
	public void getSaving()
	{
		System.out.println("\n" + "Saving Account : ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");
		
		selection = menuInput.nextInt();
		
		switch(selection)
		{
			case 1:
				System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
				getAccountType();
				break;
				
			case 2:
				getSavingWithdrawInput();
				getAccountType();
				break;
				
			case 3:
				getSavingDepositInput();
				getAccountType();
				break;
				
			case 4:
				System.out.println("Thank you for using this ATM, Bye");	
				
			default:
				System.out.println("\n" + "Invalid Choice" +"\n");
				getSaving();
		}
	}// here getSaving method ends
	
	
}// here class OptionMenu ends
