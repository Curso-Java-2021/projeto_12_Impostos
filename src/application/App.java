package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Company;
import Entities.Individual;
import Entities.TaxPayer;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List <TaxPayer> list = new ArrayList<>();
        TaxPayer tp;

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Tax payer #" + (i+1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();
            if(ch == 'i'){
                System.out.print("Health expenditures: ");
                double healthSpending = sc.nextDouble();
                tp = new Individual(name, annualIncome, healthSpending);
            }
            else{
                System.out.print("Number of employees: ");
                int numberEmployees = sc.nextInt();
                tp = new Company(name, annualIncome, numberEmployees);
            }
            list.add(tp);
        }
        sc.close();
        
        double sum = .0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for(TaxPayer t : list){   
            System.out.println(t.getName() + ": $ " + String.format("%.2f", t.tax()));
            sum += t.tax();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
    }
}
