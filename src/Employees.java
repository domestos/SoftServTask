/**
 * Created by varenik on 24.02.16.
 */
public abstract class Employees {
    protected static int count;
    protected int id ;
    protected String name;
    protected int age;
    protected double rate;
    protected double avageSalary;

    public Employees(String name, int age, double rate) {
        this.name = name;
        this.age = age;
        this.rate = rate;
        this.id = count++;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAvageSalary() {
        return avageSalary;
    }

    public void setAvageSalary(double avageSalary) {
        this.avageSalary = avageSalary;
    }

    protected abstract double avageSalary(double rate);


    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", rate=" + rate +
                ", avageSalary=" + String.format("%.2f", avageSalary) +
                '}';
    }
}
