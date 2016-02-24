import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by varenik on 24.02.16.
 */
public class FactoryEmployees {
    private static ArrayList<Employees> employees;
    private static ArrayList<Integer> listID;
    private static double fixedSalary = 26000;
    private static double hourlySalary = 155.4;
    private static int countEmployees = 10;
    private static int countLeaders = 5;
    private static int countLastID = 3;

    public static void main(String[] args) {
        employees = factoryEmploees(countEmployees);
        print(employees);
        System.out.println("\n====================================\nSort employees in descending order\n====================================");
        employees = sortDescendingOrderAvegeSalary(employees);
        print(employees);
        System.out.println("\n====================================\nWrite information about first five employees from collection\n====================================");
        employees = getLider(employees, countLeaders);
        print(employees);
        System.out.println("\n====================================\nWrite ID of three last employees from collection (problem b)\n====================================");
        listID = getLastID(employees, countLastID);
        printID(listID);
    }


    /**
     * Sort the collection of employees in descending order by the average monthly salary. In the case of
     * equal salary – by the name.
     *
     * @param employees
     * @return
     */
    private static ArrayList<Employees> sortDescendingOrderAvegeSalary(ArrayList<Employees> employees) {
        Collections.sort(employees, new Comparator<Employees>() {
            @Override
            public int compare(Employees employ, Employees employ1) {
                if (employ.getAvageSalary() == employ1.getAvageSalary()) {
                    return employ.getName().compareToIgnoreCase(employ1.getName());
                } else if (employ.getAvageSalary() > employ1.getAvageSalary()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return employees;
    }


    /**
     * Write information about first five employees from collection (problem a).
     *
     * @param employees
     * @return
     */
    private static ArrayList<Employees> getLider(ArrayList<Employees> employees, int countLeaders) {
        ArrayList<Employees> listLeaders;
        if (employees.size() >= countLeaders) {
            listLeaders = new ArrayList<>(employees.subList(0, countLeaders));
            return listLeaders;
        } else {
            listLeaders = new ArrayList<>(employees.subList(0, employees.size()));
            return listLeaders;
        }
    }


    /**
     * Write ID of three last employees from collection (problem b)
     *
     * @param employees
     * @param countLastID
     * @return
     */
    private static ArrayList<Integer> getLastID(ArrayList<Employees> employees, int countLastID) {
        ArrayList<Employees> lastLeader;
        listID = new ArrayList<>();
        if (countLastID <= employees.size()) {
            lastLeader = new ArrayList<>(employees.subList(employees.size() - countLastID, employees.size()));
        } else {
            lastLeader = new ArrayList<>(employees.subList(0, employees.size()));
        }
        for (Employees employ : lastLeader) {
            listID.add(employ.getId());
        }
        return listID;
    }


    // =============================== HELPER METHODS =================================

    /**
     * print List Employees
     *
     * @param employees
     */
    private static void print(ArrayList<Employees> employees) {
        if (employees != null) {
            for (Employees employ : employees) {
                System.out.println(employ.toString());
            }
        } else {
            System.out.printf("List Empty");
        }
    }


    /**
     * create List ID
     */
    private static void printID(ArrayList<Integer> listID) {
        if (listID != null) {
            for (Integer ID : listID) {
                System.out.println(ID);
            }
        } else {
            System.out.printf("List Empty");
        }
    }

    /**
     * create List Employees
     *
     * @param countEmploy
     * @return
     */
    private static ArrayList<Employees> factoryEmploees(int countEmploy) {
        employees = new ArrayList<>(countEmploy);
        for (int i = countEmploy; i > 0; i--) {
            if (countEmploy / 2 > i-1 ) {
                Employees fixedWageEmploy = new FixedWageEmploy("FixedEmploy " + i, 20 + i, fixedSalary+i%2);
                employees.add(fixedWageEmploy);
            } else {
                Employees hourlyWageEmploy = new HourlyWageEmploy("HourlyEmploy " + i, 20 + i, hourlySalary +i%2);
                employees.add(hourlyWageEmploy);
            }
        }
        return employees;
    }


}
