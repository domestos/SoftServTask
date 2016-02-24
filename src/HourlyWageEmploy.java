/**
 * Created by varenik on 24.02.16.
 */
public class HourlyWageEmploy extends Employees {
    public HourlyWageEmploy(String name, int age, double rate) {
        super(name, age, rate);
        avageSalary = avageSalary(rate);
    }

    @Override
    protected double avageSalary(double rate) {
        return 20.8*8*rate;
    }
}
