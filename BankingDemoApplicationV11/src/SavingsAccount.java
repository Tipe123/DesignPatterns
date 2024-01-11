public class SavingsAccount implements TypeStrategy{


    @Override
    public double collateralRatio() {
        return 1.0/2.0;
    }



    @Override
    public double interestRate() {
        return 0.01;
    }

    @Override
    public String accountType() {
        return "Savings";
    }
}
