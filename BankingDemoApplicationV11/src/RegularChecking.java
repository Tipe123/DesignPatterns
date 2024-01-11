public class RegularChecking implements TypeStrategy{



    @Override
    public double interestRate() {
        return 0;
    }

    @Override
    public double collateralRatio() {
        return 3.0/4.0;
    }

    @Override
    public String accountType() {
        return "Regular checking";
    }



}
