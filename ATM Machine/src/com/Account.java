package com;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account
{
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'Rs: '###,##0.00/-");
	
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
	
	// Set Customer Number
	public int setCustomerNumber(int customerNumber)
	{
		this.customerNumber = customerNumber;
		return customerNumber;
	}
	
	// Get Customer Number
	public int getCustomerNumber()
	{
		return customerNumber;
	}
	
	// Set Pin Number
	public int setPinNumber(int pinNumber)
	{
		this.pinNumber = pinNumber;
		return pinNumber;
	}
		
	// Get Pin Number
	public int getPinNumber()
	{
		return pinNumber;
	}
	
	// Get Checking Account Balance
	public double getCheckingBalance()
	{
		return checkingBalance;
	}
	
	// Get Saving Account Balance
	public double getSavingBalance()
	{
		return savingBalance;
	}
	
	// Calculate checking account withdrawal. Ex: 4000 - 2000 = 2000/- new checking a/c bal is 2000/-
	public double calcCheckingWithdraw(double amount)
	{
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}
	
	// Calculate saving account withdrawal. Ex: 4000 - 2000 = 2000/- new saving a/c bal is 2000/-
	public double calcSavingWithdraw(double amount)
	{
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}
	
	// Calculate checking account deposit, Ex: 4000 + 2000 = 6000/- new checking a/c bal is 6000/-
	public double calcCheckingDeposit(double amount)
	{
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}
		
	// Calculate saving account deposit, Ex: 4000 + 2000 = 6000/- new checking a/c bal is 6000/-
	public double calcSavingDeposit(double amount)
	{
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}
	
	// Customer Checking account withdraw input
	public void getCheckingWithdrawInput()
	{
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.print("Amount you want to withdraw from Checking Account: ");
		double amount = input.nextDouble();
		
		if((checkingBalance - amount) >= 0)
		{
			calcCheckingWithdraw(amount);
			System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
		}
		else
		{
			System.out.println("Balance cannot be negative." + "\n");
		}	
	}
		
	// Customer Saving account withdraw input
	public void getSavingWithdrawInput()
	{
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to withdraw from Saving Account: ");
		double amount = input.nextDouble();
			
		if((savingBalance - amount) >= 0)
		{
			calcSavingWithdraw(amount);
			System.out.println("New Saving Account Balance: " + savingBalance + "\n");
		}
		else
		{
			System.out.println("Balance cannot be negative." + "\n");
		}	
	}
		
	// Customer Checking account Deposit input	
	public void getCheckingDepositInput()
	{
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.print("Amount you want to deposit to Checking Account: ");
		double amount = input.nextDouble();
		
		if((checkingBalance + amount) >= 0)
		{
			calcCheckingDeposit(amount);
			System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
		}
		else
		{
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
	
	// Customer Saving account Deposit input	
	public void getSavingDepositInput()
	{
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to deposit to Saving Account: ");
		double amount = input.nextDouble();
			
		if((savingBalance + amount) >= 0)
		{
			calcSavingDeposit(amount);
			System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
		}
		else
		{
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
	
	
}// here Account class ends
