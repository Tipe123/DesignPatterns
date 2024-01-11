public class InterestChecking implements TypeStrategy{


    @Override
    public double interestRate() {
        return 0.01;
    }

    @Override
    public double collateralRatio() {
        return 3.0/4.0;
    }

    @Override
    public String accountType() {
        return "Interest checking";
    }


}
