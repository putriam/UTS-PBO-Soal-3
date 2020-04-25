/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soal3;

import java.awt.HeadlessException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Main { 
    public static void main(String[] args) { 
        double balance = 0; 
        double annualInterest = 0; 
        String output; 
        String input; 
        DecimalFormat df = new DecimalFormat("#0.00"); 

        do { 
            try { 
                output = "Masukkan Saldo Anda $:"; 
                input = JOptionPane.showInputDialog(output); 

                balance = Double.parseDouble(input); 
                if (balance < 0) { 
                    throw new NumberFormatException(); 
                } 
            break; 
            } catch (HeadlessException | NumberFormatException e) { 
                errorMsg(); 
            } 
        } while (true); 

        do { 
            try { 
                output = "Silahkan Masukkan Tingkat Bunga Tahunan Anda : \n" 
                + "Contoh: Bunga 4% tingkat bunganya adalah 0.04"; 
                input = JOptionPane.showInputDialog(output); 

                annualInterest = Double.parseDouble(input); 
                if (annualInterest < 0) { 
                    throw new NumberFormatException(); 
                } 
            break; 
            } catch (HeadlessException | NumberFormatException e) { 
                errorMsg(); 
            } 
        } while (true); 


        BankAccount savings = new SavingsAccount(balance, annualInterest); 
        do { 
            try { 
                output = "Masukkan Jumlah Uang yang Akan Anda Tarik:"; 
                input = JOptionPane.showInputDialog(output); 

                savings.numberOfWithdrawals = Integer.parseInt(input); 
                if (savings.numberOfWithdrawals < 0) { 
                    throw new NumberFormatException(); 
                } 
            break; 
            } catch (HeadlessException | NumberFormatException e) { 
                errorMsg(); 
            } 
        } while (true); 

        do { 
            try { 
                output = "Masukkan Jumlah Setoran Anda:"; 
                input = JOptionPane.showInputDialog(output); 

                savings.numberOfDeposits = Integer.parseInt(input); 
                if (savings.numberOfDeposits < 0) { 
                    throw new NumberFormatException(); 
                } 
            break; 
            } catch (HeadlessException e) { 
                errorMsg(); 
            } catch (NumberFormatException e) { 
                errorMsg(); 
            } 
        } while (true); 

        savings.calcInterest(); 

        output = "Saldo Akun dengan Bunga : $" + df.format(savings.getBalance()); 
        output += "\nBiaya Bulanan yang Akan Dikurangkan: $" + df.format(savings.getMonthlyCharge()); 
        output += "\nStatus Akun: "; 
        output += savings.getIsActive() ? "Aktif" : "Tidak Aktif"; 

        JOptionPane.showMessageDialog(null, output); 

} 

    private static void errorMsg() { 
        String output; 
        output = "Error: Ada yang salah terhadap yang anda masukkan"; 
        JOptionPane.showMessageDialog(null, output); 
    } 

}
