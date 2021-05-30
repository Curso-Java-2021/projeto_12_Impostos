package Entities;

public class Company extends TaxPayer{
    private int numberEmployees;

    public Company() {
        super();
    }

    public Company(String name, Double annualIncome, int numberEmployees) {
        super(name, annualIncome);
        this.numberEmployees = numberEmployees;
    }

    public int getNumberEmployees() {
        return this.numberEmployees;
    }

    public void setNumberEmployees(int numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    @Override
    public Double tax() {
        Double perc = 0.16;

        if(numberEmployees > 10){
            perc = 0.14;
        }

        return getAnnualIncome() * perc;
    }
}
