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
public class SavingsAccount extends BankAccount { 
    protected boolean isActive = (super.balance > 25); 

    public SavingsAccount() { 
        super(); 
    } 
    
    public SavingsAccount(double balance, double annualInterest) { 
        super(balance, annualInterest); 
    } 
    
    @Override
    public boolean withdraw(double amount) { 
        if (isActive) { 
            return super.withdraw(amount); 
        } else { 
            return false; 
        } 
    } 
    
     @Override
    public boolean deposit(double amount) { 
        super.deposit(amount); 
        if ((!this.isActive) && super.balance > 25) { 
            this.isActive = true; 
            return true; 
        } else { 
         return false; 
        } 
    } 

    @Override
    public void monthlyProcess() { 
        if (super.numberOfWithdrawals > 4) { 
            super.monthlyCharge += super.numberOfWithdrawals - 4; 
        if (super.balance < 25) { 
            this.isActive = false; 
        } 
        } 
    } 
    
    @Override
    public double getMonthlyCharge() { 
        this.monthlyProcess(); 
        return monthlyCharge; 
    } 

    @Override
    public boolean getIsActive() { 
        return isActive; 
    } 
    
    public void setActive(boolean isActive) { 
        this.isActive = isActive; 
    } 
}

