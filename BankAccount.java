/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soal3;

/**
 *
 * @author YACOB
 */
public abstract class BankAccount { 
    protected double balance; 
    protected int numberOfDeposits; 
    protected int numberOfWithdrawals; 
    protected double annualInterest; 
    protected double monthlyCharge; 
 
    public BankAccount(double balance, double annualInterest) { 
        this.setAnnualInterest(annualInterest);
        this.setBalance(balance); 
    } 

    public BankAccount() {} 

    public boolean deposit(double amount) { 
        if (amount > 0) { 
        this.balance += amount; 
        this.numberOfDeposits++; 
        return true; 
        } else { 
        return false; 
        } 
    } 
    
    public boolean withdraw(double amount) { 
        if ((this.balance > amount) && (amount > 0)) { 
            this.balance -= amount; 
            this.numberOfWithdrawals++; 
            return true; 
        } else { 
            return false; 
        } 
    } 
    
    protected void calcInterest() { 
        double monthlyInterestRate; 
        double monthlyInterest; 

        monthlyInterestRate = this.annualInterest / 12; 
        monthlyInterest = this.balance * monthlyInterestRate; 
        this.balance = this.balance + monthlyInterest; 
    } 
    
    public void monthlyProcess() { 
        this.balance -= this.monthlyCharge; 
        this.calcInterest(); 
        this.monthlyCharge = 0; 
        this.numberOfDeposits = 0; 
        this.numberOfWithdrawals = 0; 
    } 

    public double getBalance() { 
        return balance; 
    } 

    public void setBalance(double balance) { 
        this.balance = balance; 
    } 

    public int getNumDepositsThisMonth() { 
        return numberOfDeposits; 
    } 

    public void setNumDepositsThisMonth(int numDepositsThisMonth) { 
        this.numberOfDeposits = numDepositsThisMonth; 
    } 

    public double getAnnualInterest() { 
        return annualInterest; 
    } 

    public void setAnnualInterest(double annualInterest) { 
        this.annualInterest = annualInterest; 
    } 

    public double getMonthlyCharge() { 
        return monthlyCharge; 
    } 

    public void setMonthlyCharge(double monthlyCharge) { 
        this.monthlyCharge = monthlyCharge; 
    } 
    
    public boolean getIsActive() {  
        return (Boolean) null; 
    } 
}
