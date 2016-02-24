/**
 * Created by varenik on 24.02.16.
 */
public class FixedWageEmploy extends Employees  {

    public FixedWageEmploy(String name, int age, double rate) {
        super(name,  age, rate);
        avageSalary = avageSalary(rate);
    }

    @Override
    protected double avageSalary(double rate) {
        return rate;
    }
}
