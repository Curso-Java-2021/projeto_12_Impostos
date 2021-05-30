package Entities;

public class Individual extends TaxPayer {
    private Double healthSpending;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthSpending) {
        super(name, annualIncome);
        this.healthSpending = healthSpending;
    }

    @Override
    public Double tax() {
        Double perc;

        if(getAnnualIncome() < 20000.00){
            perc = 0.15;
        }
        else{
            perc = 0.25;
        }

        return getAnnualIncome() * perc - (healthSpending * 0.5);
    }
    
}
