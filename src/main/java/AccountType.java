public enum AccountType {
    PRIVATE(3.2),
    BUSINESS(5.1),
    YOUNG(2.3);


    private final double rate;

    AccountType(double rate){
        this.rate = rate;
    }

    public double getIntrestRate(){
        return this.rate;

    }

}
